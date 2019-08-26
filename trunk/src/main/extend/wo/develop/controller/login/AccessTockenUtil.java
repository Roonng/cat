package wo.develop.controller.login;

import wo.develop.util.EncrypDES;
import wo.develop.util.JsonHelper;
import wo.develop.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户accesstokcen生成，加密及解密工具类；默认加密解密key：1234567890
 */
public class AccessTockenUtil {

    /**
     * 创建当前登录用户的accesstoken
     * @param datamap
     * @return
     * @throws Exception
     */
    public static String encodeAccessTocken(Map datamap) throws Exception {
        String str = JsonHelper.toJSONStringForMap(datamap);
        return EncrypDES.leftMoveIndex(EncrypDES.reChange(new EncrypDES().encrypt(str)),2);
    }

    /**
     * 解密当前用户的accesstoken
     * @param data
     * @return
     * @throws Exception
     */
    public static Map decodeAccessTocken(String data) throws Exception {
        if(StringUtil.isNotNull(data)){
            return JsonHelper.toMap(new EncrypDES().decrypt(EncrypDES.reChange(EncrypDES.rightMoveIndex(data,2))));
        }else{
            return new HashMap();
        }
    }

}
