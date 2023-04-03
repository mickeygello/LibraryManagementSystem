<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>

<head>
    <title>Admin</title>
    <link rel="stylesheet" href="./css/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <%@include file="header.jsp" %>
    
    <!---------------------------------------------------------------------------------------------->
    <%@include file="menu.jsp" %>

    <!---------------------------------------------------------------------------------------------->

    <div class="accessories">

        <h1 class="accessories_title">BOOKS OF THE YEAR</h1>

        <div class="accessories_list">
            <div class="accessories_list_item">
                <div class="accessories_list_item_info">
                    <img src="images/HarryPotter.jpg" alt="HarryPotter" />
                    <h4>Harry Potter And The Philosopher's Stone</h4>
                    <p> J. K. Rowling </p>
                    <div onclick="buynow()">View Detail</div>
                </div>
            </div>

            <div class="accessories_list_item">
                <div class="accessories_list_item_info">
                    <img src="images/Moby-Dick.jpg" alt="MobyDick" />
                    <h4>Moby-Dick Or The Whale</h4>
                    <p> Herman Melville </p>
                    <div onclick="buynow()">View Detail</div>
                </div>
            </div>

            <div class="accessories_list_item">
                <div class="accessories_list_item_info">
                    <img src="images/SherlockHolmes.jpg" alt="Holmes" />
                    <h4>Sherlock Holmes</h4>
                    <p> Arthur Conan Doyle </p>
                    <div onclick="buynow()">View Detail</div>
                </div>
            </div>


            <div class="accessories_list_item">
                <div class="accessories_list_item_info">
                    <img src="images/Chainsaw_Man.jpg" alt="ChainsawMan" />
                    <h4>CHAINSAW MAN </h4>
                    <p> Tatsuki Fujimoto </p>
                    <div onclick="buynow()">View Detail</div>
                </div>
            </div>


            <div class="accessories_list_item">
                <div class="accessories_list_item_info">
                    <img src="images/TokyoGhoul.png" alt="TokyoGhoul" />
                    <h4>TOKYO GHOUL: RE</h4>
                    <p> Sui Ishida </p>
                    <div onclick="buynow()">View Detail</div>
                </div>
            </div>



            <div class="accessories_list_item">
                <div class="accessories_list_item_info">
                    <img src="images/ToYourEnternity.jpg" alt="ToYourEnternity" />
                    <h4>To Your Enternity</h4>
                    <p> Yoshitoki Oima</p>
                    <div onclick="buynow()">View Detail</div>
                </div>
            </div>


        </div>
    </div>

    <!---------------------------------------------------------------------------------------------->

    <%@include file="footer.jsp" %>
</body>

</html>