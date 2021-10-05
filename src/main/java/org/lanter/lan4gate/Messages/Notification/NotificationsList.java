package org.lanter.lan4gate.Messages.Notification;

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
    EjectCard(12),
    /**
     * Insert card into magnetic stripe reader
     */
    SwipeMagStripe(13),
    /**
     * Card reading in progress
     */
    CardReading(14),
    /**
     * Card reading error occurred
     */
    CardReadingError(15),
    /**
     * Card reading error occurred. Insert card again
     */
    CardReadingErrorTryAgain(16),
    /**
     * This card not can read. Try another card
     */
    CardReadingErrorUseAnother(17),
    /**
     * Magnetic stripe not readable.
     */
    MagStripeReadingError(18),
    /**
     * Contactless operation declined. Use chip reader
     */
    CtlsDeclinedUseChip(19),
    /**
     * Chip operation declined. Fallback to magnetic stripe.
     */
    ChipDeclinedUseMagStripe(20),
    /**
     * Reader device error
     */
    ReaderError(21),
    ChipPaymentNotAllowed(22),
    CtlsPaymentNotAllowed(23),
    MagStripePaymentNotAllowed(24),
    FallbackNotAllowed(25),
    CardBlocked(26),
    /**
     * Account blocked notifications list.
     */
    AccountBlocked(27),
    CardInBlackList(28),
    DeclinedCardExpired(29),
    DeclinedSuspectedFraud(30),
    DeclinedCallAcquirer(31),
    DeclinedCardRestricted(32),
    DeclinedCallIssuerBank(33),
    DeclinedNotAllowedForCard(34),
    DeclinedNotAllowedForCardholder(35),
    DeclinedSecurityViolation(36),
    EnterPin(37),
    PinEntered(38),
    OfflinePinEntered(39),
    IncorrectPinTryAgain(40),
    OfflinePinBlocked(41),
    OfflinePinLastTry(42),
    /**
     * Offline pin input error. Least try count. Try count sends as additional info
     */
    OfflinePinTryCount(43),
    DeclinedPinEntryLimitReached(44),
    DeclinedIncorrectPin(45),
    /**
     * Terminal battery has critical level. Any operation executing is blocked
     */
    CriticalBatteryLevel(46),
    /**
     * Terminal battery has danger level. Operation may not be executed
     */
    DangerBatteryLevel(47),
    /**
     * Entering a PIN code is required. Impossible to refuse input
     */
    ErrorPinMandatory(48),
    /**
     * Error occurred while PIN code inputs
     */
    ErrorPinInput(49),
    /**
     * Magnetic stripe operation has declined. Use chip interface
     */
    MsrDeclinedUseChip(50),
    /**
     * PIN enter timeout expired
     */
    PinEnterTimeout(51),
    QrShowing(52),
    ConfigError(53),
    KeyEntryIsNotAllowed(54),
    PinSymbolEntered(55),
    LookForDevice(56),
    DeclinedBonus(57),
    CardReadingSuccessWait(58);

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
