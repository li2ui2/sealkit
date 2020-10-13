package cn.yubai.domain;

import com.itextpdf.text.pdf.PdfSignatureAppearance;

import java.security.PrivateKey;
import java.security.cert.Certificate;

/**
 * @author LiWei
 * @date 2020/10/12 22:23
 */
public class SignatureInfo {

    /**
     * 签名的原因，显示在pdf签名属性中
     */
    private  String reason;

    /**
     * 签名的地点，显示在pdf签名属性中
     */
    private  String location;

    /**
     * 摘要算法名称，例如SHA-1
     */
    private String digestAlgorithm;

    /**
     * 图章路径
     */
    private String imagePath;

    /**
     * 表单域名称
     */
    private  String fieldName;

    /**
     * 证书链
     */
    private  Certificate[] chain;

    /**
     * 签名私钥
     */
    private PrivateKey pk;

    /**
     * 批准签章
     */
    private  int certificationLevel = 0;

    /**
     * 表现形式：仅描述，仅图片，图片和描述，签章者和描述
     */
    private PdfSignatureAppearance.RenderingMode renderingMode;

    /**
     * 图章左下角x
     */
    private float rectllx;

    /**
     * 图章左下角y
     */
    private float rectlly;

    /**
     * 图章右下角x
     */
    private float recturx;

    /**
     * 图章右上角y
     */
    private float rectury;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Certificate[] getChain() {
        return chain;
    }

    public void setChain(Certificate[] chain) {
        this.chain = chain;
    }

    public PrivateKey getPk() {
        return pk;
    }

    public void setPk(PrivateKey pk) {
        this.pk = pk;
    }

    public int getCertificationLevel() {
        return certificationLevel;
    }

    public void setCertificationLevel(int certificationLevel) {
        this.certificationLevel = certificationLevel;
    }

    public PdfSignatureAppearance.RenderingMode getRenderingMode() {
        return renderingMode;
    }

    public void setRenderingMode(PdfSignatureAppearance.RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    public float getRectllx() {
        return rectllx;
    }

    public void setRectllx(float rectllx) {
        this.rectllx = rectllx;
    }

    public float getRectlly() {
        return rectlly;
    }

    public void setRectlly(float rectlly) {
        this.rectlly = rectlly;
    }

    public float getRecturx() {
        return recturx;
    }

    public void setRecturx(float recturx) {
        this.recturx = recturx;
    }

    public float getRectury() {
        return rectury;
    }

    public void setRectury(float rectury) {
        this.rectury = rectury;
    }
}
