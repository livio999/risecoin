package rise.http;

import rise.Account;
import rise.Rise;
import rise.RiseException;
import rise.db.DbIterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public final class GetAccountLessors extends APIServlet.APIRequestHandler {

    static final GetAccountLessors instance = new GetAccountLessors();

    private GetAccountLessors() {
        super(new APITag[] {APITag.ACCOUNTS}, "account", "height");
    }

    @Override
    JSONStreamAware processRequest(HttpServletRequest req) throws RiseException {

        Account account = ParameterParser.getAccount(req);
        int height = ParameterParser.getHeight(req);
        if (height < 0) {
            height = Rise.getBlockchain().getHeight();
        }

        JSONObject response = new JSONObject();
        JSONData.putAccount(response, "account", account.getId());
        response.put("height", height);
        JSONArray lessorsJSON = new JSONArray();

        try (DbIterator<Account> lessors = account.getLessors(height)) {
            if (lessors.hasNext()) {
                while (lessors.hasNext()) {
                    Account lessor = lessors.next();
                    JSONObject lessorJSON = new JSONObject();
                    JSONData.putAccount(lessorJSON, "lessor", lessor.getId());
                    lessorJSON.put("guaranteedBalanceNQT", String.valueOf(lessor.getGuaranteedBalanceNQT(1440, height)));
                    lessorsJSON.add(lessorJSON);
                }
            }
        }
        response.put("lessors", lessorsJSON);
        return response;

    }

}
