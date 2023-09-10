<%-- 
    Document   : register
    Created on : Aug 9, 2023, 7:52:29 PM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">



    </head>
    <body>
        <%@include file="Panner.jsp" %>
        <div> 
            <section class="vh-100 gradient-custom">
                <div class="container py-5 h-100">
                    <div class="row justify-content-center align-items-center h-100">
                        <div class="col-12 col-lg-9 col-xl-7">
                            <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                                <div class="card-body p-4 p-md-5">
                                    <h3 class="mb-4 pb-2 pb-md-0 mb-md-5"> Register Account </h3>
                                    <form action="HomeUser" method="post">
                                        <input  name="service" type="hidden" value="register" />
                                        <div class="row">
                                            <div class="col-md-6 mb-4">

                                                <div class="form-outline">
                                                    <input type="text" id="firstName"  name="first"class="form-control form-control-lg" />
                                                    <label class="form-label" for="firstName">First Name</label>
                                                </div>

                                            </div>
                                            <div class="col-md-6 mb-4">

                                                <div class="form-outline">
                                                    <input type="text" id="lastName" name="last"class="form-control form-control-lg" />
                                                    <label class="form-label" for="lastName">Last Name</label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6 mb-4 ">

                                                <div class="form-outline datepicker w-100">
                                                    <input type="text" class="form-control form-control-lg" name="phone"  id="phone" />
                                                    <label for="phone" class="form-label">Phone</label>
                                                </div>

                                            </div>

                                            <div class="col-md-6 mb-4">


                                                <div class="form-outline">
                                                    <input type="email" id="emailAddress" name="email" class="form-control form-control-lg" />
                                                    <label class="form-label" for="emailAddress">Email</label>
                                                </div>



                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2">

                                                <div class="form-outline">
                                                    <input type="text" id="street" name="street" class="form-control form-control-lg" />
                                                    <label class="form-label" for="street">Street</label>
                                                </div>

                                            </div>
                                            <div class="col-md-6 mb-4 pb-2">

                                                <div class="form-outline">
                                                    <input type="text" id="city" name="city" class="form-control form-control-lg" />
                                                    <label class="form-label" for="city">City</label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="row">

                                            <div class="col-md-6 mb-4 pb-2">

                                                <div class="form-outline">
                                                    <input type="text" id="state" name="state"class="form-control form-control-lg" />
                                                    <label class="form-label" for="state">State</label>
                                                </div>

                                            </div>
                                            <div class="col-md-6 mb-4 pb-2">

                                                <div class="form-outline">
                                                    <input type="text" id="zip" name="zip" class="form-control form-control-lg" />
                                                    <label class="form-label" for="phoneNumber">Zip_Code</label>
                                                </div>

                                            </div>

                                        </div>

                                        <div class="mt-4 pt-2">
                                            <input class="btn btn-primary btn-lg" name="submitRe"type="submit" value="Submit" />
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
