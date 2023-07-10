package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Dto.ResDto;
import Domain.Service.ResService;

public class ResController {
    private ResService resService;

    public ResController() {
        resService = ResService.getInstance();
    }

    public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {
        if (serviceNo == 1) {
            String sid = (String) param.get("sid");
            List<ResDto> list = null;
            try {
                list = resService.resSearch(sid);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Map<String, Object> result = new HashMap<>();
            result.put("result", list);
            return result;
        }
        return param;
    }
}