package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Notifications list.
 */
public enum NotificationsList {
    /**
     * Upload reversal operation to host was failed.
     * While reversal not uploaded new operation can`t be executed
     */
    ReversalUploadingError(1),
    /**
     * Void amount may not be great that sale amount
     */
    IncorrectVoidAmount(2),
    /**
     * Refund amount may not be great that sale amount
     */
    IncorrectRefundAmount (3),
    /**
     * Error occurred in printer device
     */
    PrinterError(4),
    /**
     * Error occurred while receipt printing
     */
    ReceiptPrintingError(5),
    /**
     * Receipt paper out. Insert new roll
     */
    PaperOut(6),
    /**
     * Currency not supported by terminal
     */
    CurrencyNotSupported(7),
    /**
     * Connecting to host for execute operation
     */
    Connecting(8),
    /**
     * Operation is executing
     */
    Executing(9),
    /**
     * Tap card to contactless reader or insert into chip reader
     */
    TapOrInsertCard(10),
    /**
     * Insert card into chip reader
     */
    InsertCard(11),
    /**
     * Insert card into magnetic stripe reader
     */
    InsertMagStripe(12),
    /**
     * Card reading in progress
     */
    CardReading(13),
    /**
     * Card reading error occurred
     */
    CardReadingError(14),
    /**
     * Card reading error occurred. Insert card again
     */
    CardReadingErrorTryAgain(15),
    /**
     * This card not can read. Try another card
     */
    CardReadingErrorUseAnother(16),
    /**
     * Magnetic stripe not readable.
     */
    MagStripeReadingError(17),
    /**
     * Contactless operation declined. Use chip reader
     */
    CtlsDeclinedUseChip(18),
    /**
     * Chip operation declined. Fallback to magnetic stripe.
     */
    ChipDeclinedUseMagStripe(19),
    /**
     * Reader device error
     */
    ReaderError(20),
    ChipPaymentNotAllowed(21),
    CtlsPaymentNotAllowed(22),
    MagStripePaymentNotAllowed(23),
    FallbackNotAllowed(24),
    CardBlocked(25),
    /**
     * Account blocked notifications list.
     */
    AccountBlocked(26),
    CardInBlackList(27),
    DeclinedCardExpired(28),
    DeclinedSuspectedFraud(29),
    DeclinedCallAcquirer(30),
    DeclinedCardRestricted(31),
    DeclinedCallIssuerBank(32),
    DeclinedNotAllowedForCard(33),
    DeclinedNotAllowedForCardholder(34),
    DeclinedSecurityViolation(35),
    PinEntered(36),
    OfflinePinEntered(37),
    IncorrectPinTryAgain(38),
    OfflinePinBlocked(39),
    OfflinePinLastTry(40),
    /**
     * Offline pin input error. Least try count. Try count sends as additional info
     */
    OfflinePinTryCount(41),
    DeclinedPinEntryLimitReached(42),
    DeclinedIncorrectPin(43),
    /**
     * Terminal battery has critical level. Any operation executing is blocked
     */
    CriticalBatteryLevel(44),
    /**
     * Terminal battery has danger level. Operation may not be executed
     */
    DangerBatteryLevel(45);

    private final int mValue;
    private final static Map<Integer, NotificationsList> mStaticValuesMap = new HashMap<>();

    static {
        for(NotificationsList notification : NotificationsList.values()) {
            mStaticValuesMap.put(notification.mValue, notification);
        }
    }

    NotificationsList(int value) {
        mValue = value;
    }

    /**
     * Returns enum value which corresponds integer view
     *
     * @param value Card input method value
     *
     * @return Enum value, if value is correct. Null elsewhere
     */
    public static NotificationsList getValue(int value) {
        return mStaticValuesMap.get(value);
    }

    /**
     * Returns integer value which corresponds current enum value
     *
     * @return Integer value of enum
     */
    public int getNumber() {
        return mValue;
    }
}
