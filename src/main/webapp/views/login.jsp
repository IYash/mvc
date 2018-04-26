<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/5
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="config.jsp" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript" src="${jquery_js}"></script>
    <script type="text/javascript" src="${login_js}"></script>
</head>
<body>
    <form action="${context}/page/login.do?" method="post" id="submitForm">
        username:<input type="text" name="username"/><br/>
        password:<input type="password" name="password"/><br/>
        <input type="button" value="submit" id="submit1"/>
        <%--<textarea name="<?xml version"><CreateOrderRequest xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">--%>
        <%--<Token>a3855fb2f7a4a6b2c061aa051ac4e405</Token>--%>
        <%--<Order>--%>
            <%--<VendorId>22374</VendorId>--%>
            <%--<OrderId>3270082741</OrderId>--%>
            <%--<Action>Create</Action>--%>
            <%--<VendorProductCode>437398</VendorProductCode>--%>
            <%--<DepartureDate>2017-11-30T00:00:00</DepartureDate>--%>
            <%--<DistributionChannel />--%>
            <%--<OrderInfo>--%>
                <%--<BookingTime>2017-07-24T11:02:37</BookingTime>--%>
                <%--<PackageInfo>--%>
                    <%--<VendorPackageCode>437398</VendorPackageCode>--%>
                    <%--<Currency>RMB</Currency>--%>
                    <%--<ExchangeRate>1.0000</ExchangeRate>--%>
                    <%--<AdultQuantity>1</AdultQuantity>--%>
                    <%--<AdultCostPrice>329.0000</AdultCostPrice>--%>
                    <%--<ChildQuantity>0</ChildQuantity>--%>
                    <%--<ChildCostPrice>161.0000</ChildCostPrice>--%>
                    <%--<SinglePersonQuantity>0</SinglePersonQuantity>--%>
                    <%--<SinglePersonCostPrice>0</SinglePersonCostPrice>--%>
                    <%--<InfantQuantity>0</InfantQuantity>--%>
                    <%--<AdultSalesPrice>360.0000</AdultSalesPrice>--%>
                    <%--<ChildSalesPrice>176.0000</ChildSalesPrice>--%>
                    <%--<SinglePersonSalesPrice>0</SinglePersonSalesPrice>--%>
                <%--</PackageInfo>--%>
                <%--<OptionInfoList />--%>
                <%--<BoardingInfo />--%>
                <%--<TravelerList>--%>
                    <%--<Traveler>--%>
                        <%--<TravelerId>41557339</TravelerId>--%>
                        <%--<ChineseName>é??é?????è??</ChineseName>--%>
                        <%--<EnglishName />--%>
                        <%--<Gender>Female</Gender>--%>
                        <%--<Nationality>???????¤§é??</Nationality>--%>
                        <%--<BirthDate>1986-04-28</BirthDate>--%>
                        <%--<BirthCity />--%>
                        <%--<Mobile> 8615900646205</Mobile>--%>
                        <%--<AgeCategory>Adult</AgeCategory>--%>
                        <%--<IDType>IDCard</IDType>--%>
                        <%--<IDNumber>230104198604282628</IDNumber>--%>
                        <%--<IssuedDate>1900-01-01</IssuedDate>--%>
                        <%--<ExpiredDate>1900-01-01</ExpiredDate>--%>
                        <%--<IsRoomShare>true</IsRoomShare>--%>
                    <%--</Traveler>--%>
                <%--</TravelerList>--%>
                <%--<IsPaid>true</IsPaid>--%>
                <%--<VendorOperateResult>Confirmed</VendorOperateResult>--%>
                <%--<Remark>2017-07-24 11-03: [%]E6[%]B5[%]8B[%]E8[%]AF[%]95[%]E6[%]9B[%]B4[%]E5[%]A4[%]9A[%]E9[%]9C[%]80[%]E6[%]B1[%]82--%>
                    <%--??¨?????¨??·é??è????????é???±?????????????é??è??é??????????????è?·??????</Remark>--%>
                <%--<BookingContact>--%>
                    <%--<Name>é??é?????è??</Name>--%>
                    <%--<Mobile>+8615900646205</Mobile>--%>
                <%--</BookingContact>--%>
            <%--</OrderInfo>--%>
            <%--<ChangeList />--%>
            <%--<MessageId>636364910417189286</MessageId>--%>
        <%--</Order>--%>
    <%--</CreateOrderRequest></textarea>--%>
    </form>
</body>
</html>
