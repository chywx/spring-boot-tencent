package cn.chendahai.vo;

public class JsonResultFactory {

    public static JsonResult fail(String info) {
        JsonResult result = new JsonResult();
        result.setResult(JsonResult.FAIL);
        result.setInfo(info);
        return result;
    }

    public static <T> JsonResult fail(T t) {
        JsonResult result = new JsonResult();
        result.setResult(JsonResult.FAIL);
        result.setInfo("fail");
        result.setData(t);
        return result;
    }


    public static JsonResult fail(int code, String info) {
        JsonResult result = new JsonResult();
        result.setResult(code);
        result.setInfo(info);
        return result;
    }

    public static <T> JsonResult success(T t) {
        JsonResult result = new JsonResult();
        result.setResult(JsonResult.SUCCESS);
        result.setInfo("success");
        result.setData(t);
        return result;
    }

}
