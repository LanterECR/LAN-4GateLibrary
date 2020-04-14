package org.lanter.lan4gate;

import org.lanter.lan4gate.Communication.Communication;
import org.lanter.lan4gate.Communication.INewDataListener;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Assembler.JSONAssembler;
import org.lanter.lan4gate.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.Requests.RequestBuilder;
import org.lanter.lan4gate.Messages.Responses.Parser.JSONParser;

import java.util.HashSet;
import java.util.Set;

/**
 * Основной класс для работы по протоколу кассового взаимодействия LAN-4Gate
 */
public class Lan4Gate implements INewDataListener {
    private final Set<IResponseCallback> mResponseListeners = new HashSet<>();
    private final Set<INotificationCallback> mNotificationListeners = new HashSet<>();
    private final int mEcrNumber;
    private final Communication mCommunication = new Communication();

    /**
     * Конструктор принимает на вход логический номер кассового устройства
     *
     * @param ecrNumber логический номер кассового устройства,
     *                  используемый для взаимодействия с терминалом
     *                  или шлюзом LAN-4Gate
     */
    public Lan4Gate(int ecrNumber) {
        mEcrNumber = ecrNumber;
        mCommunication.addNewDataListener(this);
    }

    /**
     * Добавляет к списку получаетелей событий {@link IResponse} новый callback
     *
     * @param callback Объект, реализующий интерфейс {@link IResponseCallback}
     */
    public void addResponseCallback(IResponseCallback callback) {
        mResponseListeners.add(callback);
    }

    /**
     * Удаляет из списк получаетелей событий {@link IResponse} имеющийся callback
     *
     * @param callback Зарегистрированный объект, реализующий интерфейс {@link IResponseCallback}
     */
    public void removeResponseCallback(IResponseCallback callback) {
        mResponseListeners.remove(callback);
    }

    /**
     * Добавляет к списку получаетелей события {@link INotification} новый callback
     *
     * @param callback Объект, реализующий интерфейс {@link INotificationCallback}
     */
    public void addNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.add(callback);
    }

    /**
     * Удаляет из списк получаетелей событий {@link INotification} имеющийся callback
     *
     * @param callback Зарегистрированный объект, реализующий интерфейс {@link INotification}
     */
    public void removeNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.remove(callback);
    }

    /**
     * Устанавливает TCP порт, который будет прослушиваться сервером или клиентом
     * Порт по умолчанию в режиме сервера - 20501
     * Порт по умолчанию в режиме клиента - 20500
     * @param port Порт, который необходимо использовать для взаимодействия
     */
    public void setPort(int port) {
        mCommunication.setPort(port);
    }

    /**
     * Возвращает текущий установленный порт
     *
     * @return Текущий установленный порт
     */
    public int getPort() { return mCommunication.getPort(); }

    /**
     * Устанавливает IP, к которому будет выполняться подключение в режиме клиента
     *
     * @param ip Строка формата "127.0.0.1"
     */
    public void setIP(String ip) { }

    /**
     * Возвращает текущий используемый IP адрес в режиме клиента
     *
     * @return Строка формата "127.0.0.1"
     */
    public String getIP() { return "127.0.0.1"; }
    /**
     * Запускает сетевое взаимодействие в отдельном потоке
     */
    public void start() {
        mCommunication.startMonitoring();
    }

    /**
     * Останавливает сетевое взаимодействие
     */
    public void stop() { mCommunication.stopMonitoring(); }

    /**
     * Возвращает подготовленный объект запроса, реализующий {@link IRequest}
     * Заранее устанавливает ecrNumber, указанный при создании объекта {@link Lan4Gate}
     * и OperationCode, соответствующий перечислению {@link OperationsList}
     * @param operation Значение из перечисления {@link OperationsList}
     *
     * @return Возвращает подготовленный объект для указанной операции
     */
    public IRequest getPreparedRequest(OperationsList operation) {
        RequestBuilder builder = new RequestBuilder(mEcrNumber);
        return builder.prepareRequest(operation);
    }

    /**
     * Отправляет запрос, сформированный на основе {@link IRequest}
     *
     * @param request Объект, реализующий {@link IRequest} и заполненный
     *                в соответствии с протоколом кассового взаимодействия LAN-4Gate
     *
     */
    public void sendRequest(IRequest request){
        JSONAssembler assembler = new JSONAssembler();
        boolean result = assembler.assemble((Request) request);
        if(result) {
            mCommunication.addSendData(assembler.getJson());
        }
    }
    @Override
    public void newData(String data) {
        JSONParser parser = new JSONParser();
        if(parser.parse(data)) {
            IResponse response = parser.getResponse();
            for(IResponseCallback callback : mResponseListeners) {
                callback.newResponseMessage(response);
            }
        }
    }
}
