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
    <title>Olakoa</title>

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
		th.name{
			width:10%;			
		}
		th.thumb{
			width:20%;
		}
		th.desc{
			width:50%;
		}
		th.unit{
			width:10%;
		}
		th.posted{
			width:10%;
		}
		
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
		
		.plus{
		background: #a7aacc;
		background-image: -webkit-linear-gradient(top, #a7aacc, #2f2fad);
		background-image: -moz-linear-gradient(top, #a7aacc, #2f2fad);
		background-image: -ms-linear-gradient(top, #a7aacc, #2f2fad);
		background-image: -o-linear-gradient(top, #a7aacc, #2f2fad);
		background-image: linear-gradient(to bottom, #a7aacc, #2f2fad);
		-webkit-border-radius: 7;
		-moz-border-radius: 7;
		border-radius: 7px;
		font-family: Georgia;
		color: #ffffff;
		font-size: 13px;
		padding: 5px 10px 5px 10px;
		text-decoration: none;
		}
		
		.table{
			color: #000000;
		}
		
		.user{
			 font-style: oblique;
			
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
				<h4>Sales list </h4>
			</div>
			<br/>
			<br/>
				
			<div class= "row">
				<div class="col-md-12">
				<table class="table">
						<tr>
							<th class="name">Name</th>
							<th class="thumb">Thumbnail</th>
							<th class="desc">Description</th>
							<th class="unit">Unit</br> Cost</th>
							
						</tr>
				<c:forEach items="${drinks}" var="d">
					<tr>						
							<td class="name">${d.name}</td>
					<td class="thumb"><img src="${d.thumbnail}" alt="Mountain View" style="height:60px"></td>
					<td class="desc">${d.description}</td>
					<td class="unit">
					$
					<c:out value = "${(d.cost)/100 }"/>
					</td>
					
				</tr>			
				</c:forEach>		
			</table>
				</div>
			</div>
		
		</div>
  
	</body>
</html>