package cn.yubai.service;

import cn.yubai.domain.SignatureInfo;
import cn.yubai.utils.ItextUtil;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

/**
 * @author LiWei
 * @date 2020/10/13 10:15
 */
@Service
public class SealService {

    /**
     * keystory密码
     */
    public static final char[] PASSWORD = "123456".toCharArray();

    public void seal() {
        try {
            ItextUtil app = new ItextUtil();
            // 将证书文件放入指定路径，并读取keystore ，获得私钥和证书链
            String pkPath = "E:\\Java\\jdk1.8.0_251\\bin\\tomatocc.p12";
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream(pkPath), PASSWORD);
            String alias = ks.aliases().nextElement();
            PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);
            // 得到证书链
            Certificate[] chain = ks.getCertificateChain(alias);
            //需要进行签章的pdf
            String path = "E:\\Java\\jdk1.8.0_251\\bin\\demo.pdf";
            // 封装签章信息
            SignatureInfo signInfo = new SignatureInfo();
            signInfo.setReason("理由");
            signInfo.setLocation("位置");
            signInfo.setPk(pk);
            signInfo.setChain(chain);
            signInfo.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
            signInfo.setDigestAlgorithm(DigestAlgorithms.SHA1);
            signInfo.setFieldName("demo");
            // 签章图片
            signInfo.setImagePath("E:\\Java\\jdk1.8.0_251\\bin\\sign.jpg");
            signInfo.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
            // 值越大，代表向x轴坐标平移 缩小 （反之，值越小，印章会放大）
            signInfo.setRectllx(100);
            // 值越大，代表向y轴坐标向上平移（大小不变）
            signInfo.setRectlly(200);
            // 值越大   代表向x轴坐标向右平移  （大小不变）
            signInfo.setRecturx(400);
            // 值越大，代表向y轴坐标向上平移（大小不变）
            signInfo.setRectury(100);
            //签章后的pdf路径
            app.sign(path, "E:\\Java\\jdk1.8.0_251\\bin\\demo_seal.pdf", signInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
