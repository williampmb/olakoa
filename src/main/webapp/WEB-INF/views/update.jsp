<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Create</title>

    <!-- Bootstrap -->
  
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style type="text/css">
	
		body{
			background-color:#E6E6E6;
		}
		
		.title{
			 background: #f2eff2;
		  background-image: -webkit-linear-gradient(top, #f2eff2, #ffffff);
		  background-image: -moz-linear-gradient(top, #f2eff2, #ffffff);
		  background-image: -ms-linear-gradient(top, #f2eff2, #ffffff);
		  background-image: -o-linear-gradient(top, #f2eff2, #ffffff);
		  background-image: linear-gradient(to bottom, #f2eff2, #ffffff);
		  -webkit-border-radius: 7;
		  -moz-border-radius: 7;
		  border-radius: 7px;
		  font-family: Arial;
		  color: #7a797a;
		  font-size: 19px;
		  padding: 15px 10px 15px 15px;
		  text-decoration: none;
		}
		
		.head{
			  padding: 15px 20px 15px 20px;
		}
		
		.user{
			 font-style: oblique;
			
		}
		
		.name{
			width: 100%;
		}
		
		.description{
			width: 100%;
		}
		
		.thumb{
			width: 100%;
			
		}
		.cost{
			width: 100%;
		}
				
		.cancelBtn {
			background: #f5cc00;
			background-image: -webkit-linear-gradient(top, #f5cc00, #ed8607);
			background-image: -moz-linear-gradient(top, #f5cc00, #ed8607);
			background-image: -ms-linear-gradient(top, #f5cc00, #ed8607);
			background-image: -o-linear-gradient(top, #f5cc00, #ed8607);
			background-image: linear-gradient(to bottom, #f5cc00, #ed8607);
			-webkit-border-radius: 8;
			-moz-border-radius: 8;
			border-radius: 8px;
			font-family: Georgia;
			color: #ffffff;
			font-size: 13px;
			padding: 7px 12px 7px 12px;
			text-decoration: none;
		}

		.cancelBtn:hover {
			background: #6b5f30;
			background-image: -webkit-linear-gradient(top, #6b5f30, #db9e25);
			background-image: -moz-linear-gradient(top, #6b5f30, #db9e25);
			background-image: -ms-linear-gradient(top, #6b5f30, #db9e25);
			background-image: -o-linear-gradient(top, #6b5f30, #db9e25);
			background-image: linear-gradient(to bottom, #6b5f30, #db9e25);
			text-decoration: none;
		}
		
		.createBtn {
			background: #ffffff;
			background-image: -webkit-linear-gradient(top, #ffffff, #d4d4d4);
			background-image: -moz-linear-gradient(top, #ffffff, #d4d4d4);
			background-image: -ms-linear-gradient(top, #ffffff, #d4d4d4);
			background-image: -o-linear-gradient(top, #ffffff, #d4d4d4);
			background-image: linear-gradient(to bottom, #ffffff, #d4d4d4);
			-webkit-border-radius: 8;
			-moz-border-radius: 8;
			border-radius: 8px;
			font-family: Georgia;
			color: #000000;
			font-size: 13px;
			padding: 7px 12px 7px 12px;
			text-decoration: none;
		}

		.createBtn:hover {
			background: #999482;
			background-image: -webkit-linear-gradient(top, #999482, #f5f5f5);
			background-image: -moz-linear-gradient(top, #999482, #f5f5f5);
			background-image: -ms-linear-gradient(top, #999482, #f5f5f5);
			background-image: -o-linear-gradient(top, #999482, #f5f5f5);
			background-image: linear-gradient(to bottom, #999482, #f5f5f5);
			text-decoration: none;
		}
			
		
	</style>
  </head>
 
	<body>	
		<div class="container" >
			<br/>
			<br/>
			<div class="title">
				<div class="row">
					<div class="col-md-6">
						Olakoa
					</div>
					<div class="col-md-3">
						
					</div>
					<div class="col-md-2">
						<span>Welcome&nbsp&nbsp&nbsp</span><span class="user">${user.username}</span>
					</div>
					<div class="col-md-1">
						<a href="/olakoa/logout" class="pull-right btn-sm btn-primary">Logout</a>
					</div>
				</div>
			</div>
			<br/>			
			<div class="row head">
				<h3>Olakoa</h3>
				<h4>Create Beverage</h4>
			</div>
			<br/>
			<br/>
				
			<div class= "row">
				<div class="col-md-12">
					<form action="/olakoa/home/drinks/update/${d.id}" method="POST">
						<div class="col-md-12">
							<label>Name</br></label>
						</div>
						<div class="col-md-12">
							<input type="text" name="name" placeholder="Enter name" value="${d.name}" required></br>
						</div>
						</br>
						<div class="col-md-12">
							<label>Description</br></label>
						</div>
						<div class="col-md-12">
							<textarea rows="8"  name="description" class="description" required>${d.description} </textarea></br>
						</div>
						<div class="col-md-12">
							<label>Thumbnail</br></label>
						</div>
						<div class="col-md-12">
							<input type="url" name="thumbnail" placeholder="Thumbnail URL" value="${d.thumbnail}" required></br>
							<label>Unit Price</br></label>
						</div>
						<div class="col-md-12">
							<input type="text" name="cost" placeholder="Unit Price (cents)" value="${d.cost}" required></br>
						</div>
						<div class="col-md-12">
						</br>
							<c:if test="${d.posted}">
								<input type="checkbox" class="posted" checked>Posted</br>
							</c:if>
							<c:if test="${!d.posted}">
								<input type="checkbox" name="posted" class="posted" >Posted</br>
							</c:if>							
						</div>						
						<div class="col-md-12">
							</br>
							<a class="cancelBtn" href="/olakoa/user/drinks">Cancel<a/>						
							<input type="submit" class="createBtn" value="Update">
						</div>
					</form>
				</div>
			</div>		
		</div>  
	</body>
</html>