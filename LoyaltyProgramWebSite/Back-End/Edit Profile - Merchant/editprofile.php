<?php 

session_start();
//print_r($_SESSION);
include "../../Database/config.php";
$email = $_SESSION["email"];
//echo $email;
  $type = $_SESSION["type"];
  $sql = " SELECT * FROM merchant WHERE email = '$email' ";
  $result = mysqli_query($conn, $sql);
  $row = mysqli_fetch_assoc($result);           
  $phone = $row['phone'];
  $F_name = $row['first_name'];
  $L_name = $row['last_name'];
  $id = $row['merchant_id'];

    if(isset($_POST["submit"])){
        //echo "hello";
        //echo $id;
        $type = $_POST["type"];
        //echo $type;
        $first_name = $_POST['firstname'];
        $last_name = $_POST['lastname'];
        $emaill = $_POST['email'];
        $phone = $_POST['phone'];
        if(empty($first_name) || empty($last_name) || empty($emaill) || empty($phone) || empty($type)){
            echo "<div class='alert alert-danger'>All fields are required</div>";
      }
        else{
            if ($emaill==$email){
                $sql = "UPDATE `merchant` SET `first_name`='$first_name', `last_name`='$last_name', `email`='$emaill', `phone`='$phone', `merchant_type`='$type' WHERE `merchant_id`='$id'";
                $result = mysqli_query($conn, $sql);
                $_SESSION["email"]= $emaill;
                $_SESSION["type"]= $type;
                echo "<div class='alert alert-info'>Your information has been saved successfully..Redirecting to Login page in 5 seconds...</div>";
                echo "<script>setTimeout(function() { window.location.href = '../login/login.php'; }, 5000);</script>";
        }
            else{
                $select = " SELECT * FROM merchant WHERE email = '$emaill' ";
                $result = mysqli_query($conn, $select);
                $rowCount = mysqli_num_rows($result);
                if($rowCount > 0){
                  echo "<div class='alert alert-danger'>Email already exists!</div>";
            }
            else{
                $sql = "UPDATE `merchant` SET `first_name`='$first_name', `last_name`='$last_name', `email`='$emaill', `phone`='$phone', `merchant_type`='$type' WHERE `merchant_id`='$id'";
                $result = mysqli_query($conn, $sql);
                $_SESSION["email"]= $emaill;
                $_SESSION["type"]= $type;
                echo "<div class='alert alert-info'>Your information has been saved successfully..Redirecting to Login page in 5 seconds...</div>";
                echo "<script>setTimeout(function() { window.location.href = '../login/login.php'; }, 5000);</script>";
            }
        }
      }   }

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/edit.css">
    <title>Document</title>
</head>
<body>
    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px"
                        src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
                        class="font-weight-bold"><?php echo $F_name?></span><span> </span></div>
            </div>
            <div class="col-md-5 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <form action="" method="post">
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><input type="text" name = "firstname" class="form-control" placeholder=<?php echo $F_name?> value=""></div>
                        <div class="col-md-6"><label class="labels">Surname</label><input type="text" name = "lastname" class="form-control" value="" placeholder=<?php echo $L_name?>></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Mobile Number</label><input type="text" name = "phone" class="form-control" placeholder=<?php echo $phone?> value=""></div>
                        <div class="col-md-12"><label class="labels">Email</label><input type="email" class="form-control" name = "email" placeholder=<?php echo $email?> value=""></div>
                        <div class="col-md-12"><label class="labels">Loyalty Type</label><input type="text" class="form-control" name = "type" placeholder=<?php echo $type?> value=""></div>
                    
                    </div>
            
                    <div class="row mt-3">
                        
                    <div class="mt-5 text-center">
                    <input type="submit" value = "Save Update" class="btn btn-block btn-primary" name = "submit" >
                    </form>
                </div>
                    
                </div>
            </div>

        </div>
    </div>
    </div>
    </div>
</body>
</html>