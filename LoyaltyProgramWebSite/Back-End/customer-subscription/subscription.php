<?php 
session_start();
print_r($_SESSION);

?>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/subscription.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'> 
    <title>Welcome to subscription loyalty program</title>
</head>
<body>
    <!-- Header -->
    <header>
        <!-- Nav -->
        <header>
            <!-- Nav -->
            <div class="container">
                <div class="nav">
                    <img src="images/Untitled-4.png">
                    <a href="#" class="logo">Rewardify</a>
                    <!-- Search Bar -->
                    <form action="" class="search">
                        <input type="search" placeholder="Search">
                    </form>
                    <!-- Cart Icon -->
                    <ul>
                        <li><a href="">Home</a></li>
                        <li><a href="">Offers</a></li>
                        <li><a href="">FeedBack</a></li>
                        <li><i class='bx bx-shopping-bag' id="cart-icon"></i></li>
                    </ul>
                </div>
                <!-- Cart -->
                <div class="cart">
                    <h2 class="cart-title">Your Cart</h2>
                    <div class="cart-content">
                    </div>
                    <!-- Total -->
                    <div class="total">
                        <div class="total-title">Total</div>
                        <div class="total-price">$0</div>
                    </div>
                    <!-- Buy Button -->
                    <button type="button" class="btn-buy"><a href="#">Buy Now</a></button>
                    <!-- Cart Close -->
                    <i class="bx bx-x" id="close-cart"></i>
                </div>
            </div>
        </header>
    </header>
    <!-- Shop -->
    <section class="shop container">
        <h2 class="section-title">Shop Products</h2>
        <!-- Content -->
        <div class="shop-content">
            <!-- Box 1 -->
            <div class="product-box">
                <img src="images/product1.jpg" alt="" class="product-img">
                <h2 class="product-title">Aeroready Shirt</h2>
                <span class="price">$25</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
            <!-- Box 2 -->
            <div class="product-box">
                <img src="images/product2.jpg" alt="" class="product-img">
                <h2 class="product-title">EarBuds</h2>
                <span class="price">$100</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
            <!-- Box 3 -->
            <div class="product-box">
                <img src="images/product3.jpg" alt="" class="product-img">
                <h2 class="product-title">Hooded Parka</h2>
                <span class="price">$45</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
            <!-- Box 4 -->
            <div class="product-box">
                <img src="images/product4.jpg" alt="" class="product-img">
                <h2 class="product-title">Water Bottel</h2>
                <span class="price">$15</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
            <!-- Box 5 -->
            <div class="product-box">
                <img src="images/product5.jpg" alt="" class="product-img">
                <h2 class="product-title">sunglasses</h2>
                <span class="price">$10</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
            <!-- Box 6 -->
            <div class="product-box">
                <img src="images/product6.jpg" alt="" class="product-img">
                <h2 class="product-title">CAP</h2>
                <span class="price">$15</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
            <!-- Box 7 -->
            <div class="product-box">
                <img src="images/product7.jpg" alt="" class="product-img">
                <h2 class="product-title">Back Pack</h2>
                <span class="price">$30</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
            <!-- Box 8 -->
            <div class="product-box">
                <img src="images/product8.jpg" alt="" class="product-img">
                <h2 class="product-title">Shoes</h2>
                <span class="price">$55</span>
                <i class="bx bx-shopping-bag add-cart"></i>
            </div>
        </div>
    </section>
    <!-- JS -->
    <script src="js/offer.js"></script>
</body>
</html>
