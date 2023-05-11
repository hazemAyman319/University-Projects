<?php 

    session_start();
    //print_r($_SESSION);

    include "../../Database/config.php";
    
    if(isset($_POST["c_submit"])){
      $type = $_POST["c_type"];
      $first_name = $_POST['c_firstname'];
      $last_name = $_POST['c_lastname'];
      $pass = $_POST['c_pass'];
      $repass = $_POST['c_repass'];
      $email = $_POST['c_email'];
      $phone = $_POST['c_phone'];
      $gender = $_POST['c_gender'];
      
        
      $errors = array();
      if (empty($first_name) OR empty($last_name) OR empty($email) OR empty($pass) OR empty($repass) OR empty($phone)) {
        array_push($errors,"All fields are required");
    }
      if ($pass!==$repass) {
        array_push($errors,"Password does not match");
           }  
 
      $select = " SELECT * FROM customer WHERE email = '$email' ";
 
      $result = mysqli_query($conn, $select);
      $rowCount = mysqli_num_rows($result);
 
      if($rowCount > 0){
 
        array_push($errors,"Email already exists!");
 
      }
      if (count($errors)>0) {
        foreach ($errors as  $error) {
            echo "<div class='alert alert-danger'>$error</div>";
        }
    }
      else{
            $insert = "INSERT INTO
                                    customer (first_name, last_name, email, phone,  customer_type, password, confirm_password, gender)
                                    VALUES('$first_name','$last_name','$email','$phone','$type','$pass','$repass','$gender')";
            mysqli_query($conn, $insert);
            header('location: ../login/login.php');
         }
        
      }
      elseif(isset($_POST['m_submit'])){
        $type = $_POST["m_type"];
        $first_name = $_POST['m_firstname'];
        $last_name = $_POST['m_lastname'];
        $pass = $_POST['m_pass'];
        $repass = $_POST['m_repass'];
        $email = $_POST['m_email'];
        $phone = $_POST['m_phone'];
        $gender = $_POST['m_gender'];
  
  
        $errors = array();
        if (empty($first_name) OR empty($last_name) OR empty($email) OR empty($pass) OR empty($repass) OR empty($phone)) {
          array_push($errors,"All fields are required");
      }
        if ($pass!==$repass) {
          array_push($errors,"Password does not match");
             }  
   
        $select = " SELECT * FROM merchant WHERE email = '$email' ";
   
        $result = mysqli_query($conn, $select);
        $rowCount = mysqli_num_rows($result);
   
        if($rowCount > 0){
   
          array_push($errors,"Email already exists!");
   
        }
        if (count($errors)>0) {
          foreach ($errors as  $error) {
              echo "<div class='alert alert-danger'>$error</div>";
          }
      }
        else{
            $insert = "INSERT INTO
                                    merchant (first_name, last_name, email, phone,  merchant_type, password, confirm_password, gender)
                                    VALUES('$first_name','$last_name','$email','$phone','$type','$pass','$repass','$gender')";
              mysqli_query($conn, $insert);
              header('location: ../login/login.php');
           }
          
        }
?>


<!DOCTYPE html>
<html>
<head>
<title>Register your account with Rewardify</title>
<link rel="stylesheet" href="bootstrapCSS.css">
<script src="js/jQuery.js"></script>
<script src="js/bootstrap2.js"></script>
<link rel="stylesheet" href="login/fonts/icomoon/style.css">
<link rel="stylesheet" type="text/css" href="Reg.css">
</head>
<body class="register">
<div>
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="Images/logo/Untitled-3.png" alt="" />
            <h3>Rewardify</h3>
            <p>You are 30 seconds away from earning your own money!</p>
            <a href = "../login/login.php">
            <input type="submit" href = "../login/login.php" name="" value="Login" /><br />
            </a>
        </div>
        <div class="col-md-9 register-right">
            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="Customer-tab" data-toggle="tab" href="#Customer" role="tab"
                        aria-controls="home" aria-selected="true">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="Merchant-tab" name = "merchant" data-toggle="tab" href="#Merchant" role="tab"
                        aria-controls="profile" aria-selected="false">Merchant</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="Customer" role="tabpanel" aria-labelledby="Customer-tab">
                    <h3 class="register-heading">Apply as a Customer</h3>
                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                            <form action = "" method = "post">
                                <input type="text" class="form-control" placeholder="First Name *" value="" name="c_firstname"/>
                            </div>
                            <div class="form-group">
                            
                                <input type="text" class="form-control" placeholder="Last Name *" value="" name="c_lastname"/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password *" value="" name = "c_pass"/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirm Password *" value="" name = "c_repass"/>
                            </div>
                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <input type="radio" name="c_gender" value="male" id = "male" checked>
                                        <span> Male </span>
                                    </label>
                                    <label class="radio inline">
                                        <input type="radio" name="c_gender" value="female" id = "female" >
                                        <span> Female </span>
                                    </label>
                                </div>
                            </div>
                            
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Your Email *" value="" name = "c_email"/>
                            </div>
                            <div class="form-group">
                                <input type="text" minlength="11" maxlength="11" class="form-control"
                                    placeholder="Your Phone *" value="" name = c_phone />
                            </div>
                            <div class="form-group">
                                <select class="form-control" name = "c_type" value = "c_type" id = "c_type" >
                                    <option class="hidden" selected disabled>Choose your loyalty program</option>
                                    <option name = "point" value = "point">Point-Based Program</option>
                                    <option name = "subscription" value = "subscription">Subscription-Based Program</option>
                                    <option name = "tiered" value = "tiered">Tiered-Based Program</option>
                                    <option name = "value" value = "value">Value-Based Program</option>
                                </select>
                            </div>
                            <!-- <div class="form-group">
                                <input type="text" class="form-control" placeholder="Enter Your Answer *" value="" />
                            </div> -->
                            <input type="submit" class="btnRegister" value="Register" name = "c_submit" />
                        </div>
                    </div>
 </form>
                </div>
                
                <div class="tab-pane fade show" id="Merchant" role="tabpanel" aria-labelledby="profile-tab">
                    <h3 class="register-heading">Apply as a Merchant</h3>
                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                            <form action = "" method = "post">
                            <input type="text" class="form-control" placeholder="First Name *" value="" name="m_firstname"/>
                            </div>
                            <div class="form-group">
                            <input type="text" class="form-control" placeholder="Last Name *" value="" name="m_lastname"/>
                            </div>
                            <div class="form-group">
                            <input type="email" class="form-control" placeholder="Your Email *" value="" name = "m_email"/>
                            </div>
                            <div class="form-group">
                            <input type="text" minlength="11" maxlength="11" class="form-control"
                                    placeholder="Your Phone *" value="" name = m_phone />
                            </div>
                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <input type="radio" name="m_gender" value="male" id = "male" checked>
                                        <span> Male </span>
                                    </label>
                                    <label class="radio inline">
                                        <input type="radio" name="m_gender" value="female" id = "female" >
                                        <span> Female </span>
                                    </label>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password *" value="" name = "m_pass"/>
                            </div>
                            <div class="form-group">
                            <input type="password" class="form-control" placeholder="Confirm Password *" value="" name = "m_repass"/>
                            </div>
                            <div class="form-group">
                                <select class="form-control" name = "m_type" value = "m_type" id = "m_type" >
                                    <option class="hidden" selected disabled>Choose your loyalty program</option>
                                    <option name = "point" value = "point">Point-Based Program</option>
                                    <option name = "subscription" value = "subscription">Subscription-Based Program</option>
                                    <option name = "tiered" value = "tiered">Tiered-Based Program</option>
                                    <option name = "value" value = "value">Value-Based Program</option>
                                </select>
                            </div>
                            <!-- <div class="form-group">
                                <input type="text" class="form-control" placeholder="`Answer *" value="" />
                            </div> -->
                            <input type="submit" class="btnRegister" value="Register" name = "m_submit" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>

</div>
</body>
</html>