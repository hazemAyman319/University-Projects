<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/add.css">
    <title>Document</title>
</head>
<body>
    <div class="nav pt-2">
        <div class="container">
            <div class="content">
                <a href="#">
                    <img class="logo" src="images/logo.png">
                </a>
                <!-- Cart Icon -->
                <ul>
                    <li><i class='bx bx-user user-icon'></i></li>
                </ul>
            </div>
        </div>
    </div>
    
<div class="container">
    <div class="row justify-content-center h-25 mt-5">
        <form action="">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Product Name</label>
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="e.g. Shirt">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Price</label>
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="e.g. $30">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Subscription</label>
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="e.g. yearly">
            </div>
            <div class="input-group mb-4">
                <label class="input-group-text" for="inputGroupFile01">Upload</label>
                <input type="file" class="form-control" id="inputGroupFile01">
            </div>
            <button type="button" class="btn btn-success me-4">Add</button>
            <button type="button" class="btn btn-secondary button1">Edit</button>
            <button type="button" class="btn btn-danger button1">Delete</button>
        </form>
    </div>
</div>

    <section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-primary">
						    <tr style="background-color: #0c5d61">
						    	<th>No.</th>
						    	<th>Image</th>
						    	<th>Product</th>
								<th>Price</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr class="alert" role="alert">
						    	<td><!-- Add number here --></td>
						    	<td>
						    		<div class="img" style="background-image: url(/*Img Link Here*/);"></div>
						    	</td>
						      	<td>
									<div class="email">
										<span><!-- Add Product Name here --></span>
										<span> </span>
									</div>
						      	</td>
						      <td><!-- Add price here --></td>
						    </tr>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
    <script src="js/all.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>