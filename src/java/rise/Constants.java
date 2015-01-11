package rise;

import java.util.Calendar;
import java.util.TimeZone;

public final class Constants {

	public static int DIFF_ADJUST_CHANGE_BLOCK = 100;
	public static long REWARD_RECIPIENT_ASSIGNMENT_WAIT_TIME = 4;
	
	public static final int BLOCK_HEADER_LENGTH = 232;
    public static final int MAX_NUMBER_OF_TRANSACTIONS = 255;
    public static final int MAX_PAYLOAD_LENGTH = MAX_NUMBER_OF_TRANSACTIONS * 176;
    public static final long MAX_BALANCE_RISE = 1000000000;
    public static final long ONE_RISE = 100000000;
    public static final long MAX_BALANCE_NQT = MAX_BALANCE_RISE * ONE_RISE;
    public static final long STARTING_NQT = 43000000 * ONE_RISE;;
    public static final long INITIAL_HDD_BASE_TARGET = 18325193796L;
    public static final long INITIAL_POS_BASE_TARGET = 15372286700L;
    public static final int MAX_ROLLBACK = Rise.getIntProperty("rise.maxRollback");
    static {
        if (MAX_ROLLBACK < 1440) {
            throw new RuntimeException("rise.maxRollback must be at least 1440");
        }
    }

    public static final int MAX_ALIAS_URI_LENGTH = 1000;
    public static final int MAX_ALIAS_LENGTH = 100;

    public static final int MAX_ARBITRARY_MESSAGE_LENGTH = 1000;
    public static final int MAX_ENCRYPTED_MESSAGE_LENGTH = 1000;

    public static final int MAX_ACCOUNT_NAME_LENGTH = 100;
    public static final int MAX_ACCOUNT_DESCRIPTION_LENGTH = 1000;

    public static final long MAX_ASSET_QUANTITY_QNT = 1000000000L * 100000000L;
    public static final int MIN_ASSET_NAME_LENGTH = 3;
    public static final int MAX_ASSET_NAME_LENGTH = 10;
    public static final int MAX_ASSET_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_ASSET_TRANSFER_COMMENT_LENGTH = 1000;

    public static final int MAX_POLL_NAME_LENGTH = 100;
    public static final int MAX_POLL_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_POLL_OPTION_LENGTH = 100;
    public static final int MAX_POLL_OPTION_COUNT = 100;

    public static final int MAX_DGS_LISTING_QUANTITY = 1000000000;
    public static final int MAX_DGS_LISTING_NAME_LENGTH = 100;
    public static final int MAX_DGS_LISTING_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_DGS_LISTING_TAGS_LENGTH = 100;
    public static final int MAX_DGS_GOODS_LENGTH = 10240;

    public static final int MAX_HUB_ANNOUNCEMENT_URIS = 100;
    public static final int MAX_HUB_ANNOUNCEMENT_URI_LENGTH = 1000;
    public static final long MIN_HUB_EFFECTIVE_BALANCE = 100000;

    public static final boolean isTestnet = Rise.getBooleanProperty("rise.isTestnet");
    public static final boolean isOffline = Rise.getBooleanProperty("rise.isOffline");

    public static final int ALIAS_SYSTEM_BLOCK = 0;
    public static final int TRANSPARENT_FORGING_BLOCK = 0;
    public static final int ARBITRARY_MESSAGES_BLOCK = 0;
    public static final int TRANSPARENT_FORGING_BLOCK_2 = 0;
    public static final int TRANSPARENT_FORGING_BLOCK_3 = 0;
    public static final int TRANSPARENT_FORGING_BLOCK_4 = 0;
    public static final int TRANSPARENT_FORGING_BLOCK_5 = 0;
    public static final int TRANSPARENT_FORGING_BLOCK_6 = 0;
    public static final int TRANSPARENT_FORGING_BLOCK_7 = Integer.MAX_VALUE;
    public static final int TRANSPARENT_FORGING_BLOCK_8 = 0;
    public static final int NQT_BLOCK = 0;
    public static final int FRACTIONAL_BLOCK = 0;
    public static final int ASSET_EXCHANGE_BLOCK = 0;
    public static final int REFERENCED_TRANSACTION_FULL_HASH_BLOCK = 0;
    public static final int REFERENCED_TRANSACTION_FULL_HASH_BLOCK_TIMESTAMP = 0;
    public static final int VOTING_SYSTEM_BLOCK = Integer.MAX_VALUE;
    public static final int DIGITAL_GOODS_STORE_BLOCK = 0;
    public static final int PUBLIC_KEY_ANNOUNCEMENT_BLOCK = Integer.MAX_VALUE;
    public static final int LAST_KNOWN_BLOCK = 0;

    static final long UNCONFIRMED_POOL_DEPOSIT_NQT = (isTestnet ? 50 : 100) * ONE_RISE;

    public static final long EPOCH_BEGINNING;
    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH_BEGINNING = calendar.getTimeInMillis();
    }

    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static final int EC_RULE_TERMINATOR = 2400; /* cfb: This constant defines a straight edge when "longest chain"
                                                        rule is outweighed by "economic majority" rule; the terminator
                                                        is set as number of seconds before the current time. */

    public static final int EC_BLOCK_DISTANCE_LIMIT = 60;

    private Constants() {} // never

}