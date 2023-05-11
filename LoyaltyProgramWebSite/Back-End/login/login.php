
<?php 
include "../../Database/config.php";
session_start();
if(isset($_session['email'])){
  echo "hello";
}
//print_r($_SESSION);

if(isset($_POST["submit"])) { 
  $selectedOption = $_POST["usertype"];
  $email = $_POST["email"];
  $pass = $_POST["pass"]; 
  if (empty($email) OR empty($pass)) {
    echo "<div class='alert alert-danger'>All fields are required</div>";}
    else{
      if($selectedOption == "customer") { 
        $select = " SELECT * FROM customer WHERE email = '$email' && password = '$pass' ";
        $result = mysqli_query($conn, $select);
        $rowCount = mysqli_num_rows($result);
        if($rowCount > 0){
              $_SESSION['email'] = $email;
              $sql = " SELECT customer_type FROM customer WHERE email = '$email' && password = '$pass' ";
              $result = mysqli_query($conn, $sql);
              $row = mysqli_fetch_assoc($result);
              $type = $row["customer_type"];
              $_SESSION['type'] = $type;
              if($type == "point"){
                header("Location: ../profile/profile.php");
              }
              elseif($type == "value"){
                header("Location: ../offers/value.php");
              }
              elseif($type == "tiered"){
                //header("Location: ../customer-tiered/tiered.php");
              }
              elseif($type == "subscription"){
                header("Location: ../customer-subscription/subscription.php");
              }
        } 
        else{
          echo "<div class='alert alert-danger'>Wrong Name OR Password</div>";
        }
      
      }
      if($selectedOption == "merchant"){
        $select = " SELECT * FROM merchant WHERE email = '$email' && password = '$pass' ";
        $result = mysqli_query($conn, $select);
        $rowCount = mysqli_num_rows($result);
        if($rowCount > 0){
              $_SESSION['email'] = $email;
              $sql = " SELECT merchant_type FROM merchant WHERE email = '$email' && password = '$pass' ";
              $result = mysqli_query($conn, $sql);
              $row = mysqli_fetch_assoc($result);
              $type = $row["merchant_type"];
              $_SESSION['type'] = $type;
              if($type == "point"){
                //header("Location: merchantpoint.php");
              }
              elseif($type == "value"){
                //header("Location: merchantvalue.php");
              }
              elseif($type == "tiered"){
                header("Location: merchanttiered.php");
              }
              elseif($type == "subscription"){
                header("Location: merchantsubscription.php");
              }
        } 
        else{
          echo "<div class='alert alert-danger'>Wrong Name OR Password</div>";
        }

      }
    }
}
//session_destroy();

?>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Rewardify</title>
  </head>
  <body>
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <div class="mb-4">
              <h3>Sign In</h3>
              <p class="mb-4">Welcome Back!</p>
            </div>
            <form action="" method="post">
              <!-- Email Label -->
              <div class="form-group first">
                <label for="Email">Email</label>
                <input type="text" name = "email" class="form-control" id="email">

              </div>
              <!-- Password Label -->
              <div class="form-group last mt-3 mb-3">
                <label for="password">Password</label>
                <input type="password" name = "pass" class="form-control" id="password">
              </div>
              <!-- ************************** -->
              <div class="d-flex mb-4 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
              </div>
              <!-- ************************** -->
              <div class="mt-3 mb-4">
                <p class="mb">&mdash; Sign in as &mdash;</p>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="usertype" id="merchant" value="merchant" checked>
                  <label class="form-check-label" for="inlineRadio1">Merchant</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="usertype" id="customer" value="customer">
                  <label class="form-check-label" for="inlineRadio2">Customer</label>
                </div>
              </div>
              <!-- Submit Button -->
              <input type="submit" value="Log In" class="btn btn-block btn-primary" name = "submit">
            </form>
            <div class="mt-4">
            <p>Don't have an account?<span><a href="../Registration/Registration.php" style="color: blue;"> Sign Up</a></span></p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>

