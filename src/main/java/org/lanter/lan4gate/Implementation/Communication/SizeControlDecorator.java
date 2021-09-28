package org.lanter.lan4gate.Implementation.Communication;

import org.lanter.lan4gate.Communication.ICommunication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SizeControlDecorator implements ICommunication {

    private final ByteArrayOutputStream mCurrentDataStreamBuffer = new ByteArrayOutputStream();
    private final Queue<byte[]> mReceivedData = new ConcurrentLinkedDeque<>();

    private int mMessageSize = -1;
    private final int mSizeCharsCount = 4;


    private final ICommunication mCommunication;

    public SizeControlDecorator(ICommunication communication) {
        mCommunication = communication;
    }
    @Override
    public void openCommunication() throws IOException {
        if(mCommunication != null) {
            mCommunication.openCommunication();
        }
    }

    @Override
    public void closeCommunication() throws IOException {
        if(mCommunication != null) {
            mCommunication.closeCommunication();
        }
    }

    @Override
    public boolean isOpen() {
        boolean result = false;
        if(mCommunication != null) {
            result = mCommunication.isOpen();
        }
        return result;
    }

    @Override
    public void connect() throws IOException {
        if(mCommunication != null) {
            mCommunication.connect();
        }
    }

    @Override
    public void disconnect() throws IOException {
        if(mCommunication != null) {
            mCommunication.disconnect();
        }
    }

    @Override
    public boolean isConnected() {
        boolean result = false;
        if(mCommunication != null) {
            result = mCommunication.isConnected();
        }
        return result;
    }

    @Override
    public void sendData(byte[] data) throws IOException {
        if(mCommunication != null && data != null && data.length > 0) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            stream.write(getSendSize(data).getBytes());
            stream.write(data);
            byte[] arr = stream.toByteArray();
            byte[] buf = Arrays.copyOfRange(arr, 0, mSizeCharsCount + data.length);
            mCommunication.sendData(buf);
        }
    }

    @Override
    public byte[] getData() throws IOException {
        if(mCommunication != null) {
            byte[] buffer = mCommunication.getData();
            if(buffer != null) {
                mCurrentDataStreamBuffer.write(buffer, 0, buffer.length);
            }
            if(mCurrentDataStreamBuffer.size() > 0) {
                if(mMessageSize < 0) {
                    mMessageSize = getReceiveSize(mCurrentDataStreamBuffer.toByteArray());
                }
                if (mMessageSize > 0) {
                    byte[] message = getReceiveData(mCurrentDataStreamBuffer.toByteArray(), mMessageSize);
                    if(message != null) {
                        mReceivedData.offer(message);
                        sliceStream();
                        mMessageSize = -1;
                    }
                }
            }
        }
        return mReceivedData.poll();
    }

    @Override
    public void doCommunication() throws IOException {
        if(mCommunication != null) {
            mCommunication.doCommunication();
        }
    }

    private String getSendSize(byte[] buffer) {
        return String.format("%0" + mSizeCharsCount +"X", buffer.length);
    }

    private int getReceiveSize(byte[] buffer) {
        int result = -1;
        if(buffer.length >= mSizeCharsCount) {
            String size = new String(buffer, 0, mSizeCharsCount, StandardCharsets.UTF_8);
            if(size.matches("[0-9a-fA-F]{" + mSizeCharsCount + "}")) {
                result = Integer.parseInt(size, 16);
            }
        }
        return result;
    }
    private byte[] getReceiveData(byte[] data, int dataSize) {
        byte[] result = null;
        if(data.length >= dataSize + mSizeCharsCount) {
            result = Arrays.copyOfRange(data, mSizeCharsCount, mSizeCharsCount + dataSize);
        }
        return result;
    }
    private void sliceStream() {
        byte[] array = mCurrentDataStreamBuffer.toByteArray();
        mCurrentDataStreamBuffer.reset();
        int offset = mSizeCharsCount + mMessageSize;
        int len = array.length - mSizeCharsCount - mMessageSize;
        if(offset < array.length && len > 0) {
            mCurrentDataStreamBuffer.write(array, offset, len);
        }
    }
}

