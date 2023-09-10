<%-- 
    Document   : loginAdmin
    Created on : Aug 11, 2023, 12:38:47 PM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <title>Admin Login</title>
    </head>
    <body>
           <div> 
            <section class="vh-100 gradient-custom">
                <div class="container py-5 h-100">
                    <div class="row justify-content-center align-items-center h-100">
                        <div class="col-12 col-lg-9 col-xl-7">
                            <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                                <div class="card-body p-4 p-md-5">
                                    <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">  Admin Login </h3>
                                    <form action="AdminLogin" method="post"> 

                                        <div class="row">
                                            <div class="col-md-6 mb-4">

                                                <div class="form-outline">
                                                    
                                                    <input type="email" id="emailAddress" name="email" class="form-control form-control-lg" />
                                                    <label class="form-label" for="emailAddress">Email</label>
                                                </div>
                                            </div>
                                        </div>

                                          <div class="row">
                                            <div class="col-md-6 mb-4">

                                                <div class="form-outline">
                                                    
                                                    <input type="password" id="emailAddress" name="password" class="form-control form-control-lg" />
                                                    <label class="form-label" for="password">Pass word</label>
                                                </div>
                                            </div>
                                        </div>
                                        <p style="color: red"> ${erro}</p>
                                        <div class="mt-4 pt-2">
                                            <input class="btn btn-primary btn-lg" name="submit" type="submit" value="Login" />
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
               
             
        </div>
    </body>
</html>
