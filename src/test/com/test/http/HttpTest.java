package com.test.http;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * @author huangchangling on 2017/7/27 0027
 */
public class HttpTest {

    private String xmlPostUrl = "http://10.112.6.45:8081/mvc/xmlParse.do";
    private String jsonPostUrl = "http://open.sh.trip.meituan.com/triphsapi/TriggerUpdateStockPrice";

    private String xmlData;

    private final static String REG = "[ \\[ \\] ]";//这种过虑方式有问题%E6%B5%8B%E8%AF%95%E6%9B%B4%E5%A4%9A%E9%9C%80%E6%B1%82
    private Pattern pattern = Pattern.compile(REG) ;

    @Test
    public void testXmlParse() throws Exception{

        //xmlData = getCorrectXml();
        xmlData = getXml();
        //xmlData = pattern.matcher(getXml()).replaceAll("");
        HttpClient client = new DefaultHttpClient();
        //HttpPost post = new HttpPost(xmlPostUrl);
        HttpPost post = new HttpPost(jsonPostUrl);
        post.setHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
       // post.setEntity(new StringEntity(xmlData));
        post.setEntity(new StringEntity(getJson()));
        HttpResponse response = client.execute(post);
        BufferedReader io=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String data = null;
        while((data = io.readLine())!=null){
            System.out.println(data);
        }

    }
    private String getJson(){
        String jsonStr = "{\n" +
                "  \"productId\": \"1078817\" "+"}";
        return jsonStr;
    }
    private String getXml(){

        String xml = "<?xml version=\"1.0\"?>\n" +
                "<CreateOrderRequest xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <Token>a3855fb2f7a4a6b2c061aa051ac4e405</Token>\n" +
                "  <Order>\n" +
                "    <VendorId>22374</VendorId>\n" +
                "    <OrderId>3270082741</OrderId>\n" +
                "    <Action>Create</Action>\n" +
                "    <VendorProductCode>437398</VendorProductCode>\n" +
                "    <DepartureDate>2017-11-30T00:00:00</DepartureDate>\n" +
                "    <DistributionChannel />\n" +
                "    <OrderInfo>\n" +
                "      <BookingTime>2017-07-24T11:02:37</BookingTime>\n" +
                "      <PackageInfo>\n" +
                "        <VendorPackageCode>437398</VendorPackageCode>\n" +
                "        <Currency>RMB</Currency>\n" +
                "        <ExchangeRate>1.0000</ExchangeRate>\n" +
                "        <AdultQuantity>1</AdultQuantity>\n" +
                "        <AdultCostPrice>329.0000</AdultCostPrice>\n" +
                "        <ChildQuantity>0</ChildQuantity>\n" +
                "        <ChildCostPrice>161.0000</ChildCostPrice>\n" +
                "        <SinglePersonQuantity>0</SinglePersonQuantity>\n" +
                "        <SinglePersonCostPrice>0</SinglePersonCostPrice>\n" +
                "        <InfantQuantity>0</InfantQuantity>\n" +
                "        <AdultSalesPrice>360.0000</AdultSalesPrice>\n" +
                "        <ChildSalesPrice>176.0000</ChildSalesPrice>\n" +
                "        <SinglePersonSalesPrice>0</SinglePersonSalesPrice>\n" +
                "      </PackageInfo>\n" +
                "      <OptionInfoList />\n" +
                "      <BoardingInfo />\n" +
                "      <TravelerList>\n" +
                "        <Traveler>\n" +
                "          <TravelerId>41557339</TravelerId>\n" +
                "          <ChineseName>郑雪测试</ChineseName>\n" +
                "          <EnglishName />\n" +
                "          <Gender>Female</Gender>\n" +
                "          <Nationality>中国大陆</Nationality>\n" +
                "          <BirthDate>1986-04-28</BirthDate>\n" +
                "          <BirthCity />\n" +
                "          <Mobile>+8615900646205</Mobile>\n" +
                "          <AgeCategory>Adult</AgeCategory>\n" +
                "          <IDType>IDCard</IDType>\n" +
                "          <IDNumber>230104198604282628</IDNumber>\n" +
                "          <IssuedDate>1900-01-01</IssuedDate>\n" +
                "          <ExpiredDate>1900-01-01</ExpiredDate>\n" +
                "          <IsRoomShare>true</IsRoomShare>\n" +
                "        </Traveler>\n" +
                "      </TravelerList>\n" +
                "      <IsPaid>true</IsPaid>\n" +
                "      <VendorOperateResult>Confirmed</VendorOperateResult>\n" +
                "      <Remark>2017-07-24 11-03:%E6%B5%8B%E8%AF%95%E6%9B%B4%E5%A4%9A%E9%9C%80%E6%B1%82  注：用户预订特殊需求，如与本预订项目无关，请忽略</Remark>\n" +
                "      <BookingContact>\n" +
                "        <Name>郑雪测试</Name>\n" +
                "        <Mobile>+8615900646205</Mobile>\n" +
                "      </BookingContact>\n" +
                "    </OrderInfo>\n" +
                "    <ChangeList />\n" +
                "    <MessageId>636364910417189286</MessageId>\n" +
                "  </Order>\n" +
                "</CreateOrderRequest>";
        //%E6%B5%8B%E8%AF%95%E6%9B%B4%E5%A4%9A%E9%9C%80%E6%B1%82
        //[%]E6[%]B5[%]8B[%]E8[%]AF[%]95[%]E6[%]9B[%]B4[%]E5[%]A4[%]9A[%]E9[%]9C[%]80[%]E6[%]B1[%]82
        return xml;
    }

    private String getCorrectXml(){
        return "<?xml version=\"1.0\"?>\n" +
                "<CreateOrderRequest xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <Token>a3855fb2f7a4a6b2c061aa051ac4e405</Token>\n" +
                "  <Order>\n" +
                "    <VendorId>22374</VendorId>\n" +
                "    <OrderId>3233233399</OrderId>\n" +
                "    <Action>Create</Action>\n" +
                "    <VendorProductCode>437398</VendorProductCode>\n" +
                "    <DepartureDate>2017-11-30T00:00:00</DepartureDate>\n" +
                "    <DistributionChannel />\n" +
                "    <OrderInfo>\n" +
                "      <BookingTime>2017-07-20T16:04:20</BookingTime>\n" +
                "      <PackageInfo>\n" +
                "        <VendorPackageCode>437398</VendorPackageCode>\n" +
                "        <Currency>RMB</Currency>\n" +
                "        <ExchangeRate>1.0000</ExchangeRate>\n" +
                "        <AdultQuantity>1</AdultQuantity>\n" +
                "        <AdultCostPrice>329.0000</AdultCostPrice>\n" +
                "        <ChildQuantity>1</ChildQuantity>\n" +
                "        <ChildCostPrice>161.0000</ChildCostPrice>\n" +
                "        <SinglePersonQuantity>0</SinglePersonQuantity>\n" +
                "        <SinglePersonCostPrice>0</SinglePersonCostPrice>\n" +
                "        <InfantQuantity>0</InfantQuantity>\n" +
                "        <AdultSalesPrice>360.0000</AdultSalesPrice>\n" +
                "        <ChildSalesPrice>176.0000</ChildSalesPrice>\n" +
                "        <SinglePersonSalesPrice>0</SinglePersonSalesPrice>\n" +
                "      </PackageInfo>\n" +
                "      <OptionInfoList />\n" +
                "      <BoardingInfo />\n" +
                "      <TravelerList>\n" +
                "        <Traveler>\n" +
                "          <TravelerId>41472889</TravelerId>\n" +
                "          <ChineseName>郑雪测试</ChineseName>\n" +
                "          <EnglishName />\n" +
                "          <Gender>Female</Gender>\n" +
                "          <Nationality>中国大陆</Nationality>\n" +
                "          <BirthDate>1986-04-28</BirthDate>\n" +
                "          <BirthCity />\n" +
                "          <Mobile>+8615900646205</Mobile>\n" +
                "          <AgeCategory>Adult</AgeCategory>\n" +
                "          <IDType>IDCard</IDType>\n" +
                "          <IDNumber>230104198604282628</IDNumber>\n" +
                "          <IssuedDate>1900-01-01</IssuedDate>\n" +
                "          <ExpiredDate>1900-01-01</ExpiredDate>\n" +
                "          <IsRoomShare>true</IsRoomShare>\n" +
                "        </Traveler>\n" +
                "        <Traveler>\n" +
                "          <TravelerId>41472890</TravelerId>\n" +
                "          <ChineseName>王小西</ChineseName>\n" +
                "          <EnglishName />\n" +
                "          <Gender>Female</Gender>\n" +
                "          <Nationality>中国大陆</Nationality>\n" +
                "          <BirthDate>2010-01-01</BirthDate>\n" +
                "          <BirthCity />\n" +
                "          <Mobile />\n" +
                "          <AgeCategory>Child</AgeCategory>\n" +
                "          <IDType>IDCard</IDType>\n" +
                "          <IDNumber>230104201001012869</IDNumber>\n" +
                "          <IssuedDate>1900-01-01</IssuedDate>\n" +
                "          <ExpiredDate>1900-01-01</ExpiredDate>\n" +
                "          <IsRoomShare>true</IsRoomShare>\n" +
                "        </Traveler>\n" +
                "      </TravelerList>\n" +
                "      <IsPaid>true</IsPaid>\n" +
                "      <VendorOperateResult>Confirmed</VendorOperateResult>\n" +
                "      <Remark>2017-07-20 16-05: 测试订单，请不要资审 注：用户预订特殊需求，如与本预订项目无关，请忽略</Remark>\n" +
                "      <BookingContact>\n" +
                "        <Name>郑雪测试</Name>\n" +
                "        <Mobile>+8615900646205</Mobile>\n" +
                "      </BookingContact>\n" +
                "    </OrderInfo>\n" +
                "    <ChangeList />\n" +
                "    <MessageId>636361635513449091</MessageId>\n" +
                "  </Order>\n" +
                "</CreateOrderRequest>";
    }
}
