package com.bit.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.youiwe.webservice.ServiceSMSSoapProxy;

@Controller
public class SmsController {

	@RequestMapping("/send.do")
	@ResponseBody
	public String send(String authTel) {
		String sendNumber = "";
		
		
		//������ ���� 4�ڸ� ����
		Random rd = new Random();
		int n = 0;
		while(n < 1000) {
			n = rd.nextInt(10000);
		}
		
		sendNumber = n + "";
		
		String smsID = "rola";
		String smsPW = "bit123400";

		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		try {
			//������ �����¹�ȣ�� �Է��ϼ���
			String senderPhone = "01036517605";
			//�޴¹�ȣ�� �Է��ϼ���
			String receivePhone = authTel;
			//������ �Է��ϼ���
			String smsContent = sendNumber;
			String test1 = (smsID + smsPW + receivePhone);
			CEncrypt encrypt = new CEncrypt("MD5", test1);
			java.lang.String send = sendsms.sendSMS(smsID, encrypt.getEncryptData(), senderPhone, receivePhone,
					smsContent);
			System.out.println("����ڵ�:" + send);
		} catch (Exception e) {
			System.out.println("Exception in main:" + e);
		}
		
		return sendNumber;
	}

	class CEncrypt
	{
		    MessageDigest md;
		    String strSRCData = "";
		    String strENCData = "";

		    public CEncrypt(){}
		    //�ν��Ͻ� ���� �� �ѹ濡 ó���� �� �ֵ��� ������ �ߺ����׽��ϴ�. 
		    public CEncrypt(String EncMthd, String strData)
		    {
		        this.encrypt(EncMthd, strData);
		    }

		    //��ȣȭ ������ �����ϴ� �޼ҵ��Դϴ�.
		    public void encrypt(String EncMthd, String strData)
		   {
		       try
		      {
		          MessageDigest md = MessageDigest.getInstance(EncMthd); // "MD5" or "SHA1"
		         byte[] bytData = strData.getBytes();
		         md.update(bytData);

		         byte[] digest = md.digest();
		         StringBuffer sb = new StringBuffer();
		         for(int i =0;i<digest.length;i++)
		         {
		        	 strENCData = sb.append(Integer.toString((digest[i]&0xff) + 0x100, 16).substring(1)).toString();
		         }
		       }catch(NoSuchAlgorithmException e)
		      {
		         System.out.print("��ȣȭ �˰����� �����ϴ�.");
		      };
		    
		      //���߿� ���� �����Ͱ� �ʿ����� ���� ������ �Ӵϴ�.
		      strSRCData = strData;
		    }

		    //������ �ζ��� �Լ�(�ƴ�, �޼ҵ�)���Դϴ�.
		    public String getEncryptData(){return strENCData;}
		    public String getSourceData(){return strSRCData;}

		    //�����Ͱ� ������ �����ִ� �޼ҵ��Դϴ�.
		    public boolean equal(String strData)
		    {
		      //��ȣȭ �����Ͷ� �񱳸� �ϴ�, �����̶� �񱳸� �ϴ� �����....
		      if(strData == strENCData) return true;
		      return false;
		    }
	}

}

