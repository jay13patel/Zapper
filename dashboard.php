<?php
 $page = "Dashboard";
 include "header.php" ?>

    <div class="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="page-head-line">Dashboard</h4>
                </div>
            </div>
           
            <div class="row">
                <div class="col-md-3 col-sm-3 col-xs-6">
                    <div class="dashboard-div-wrapper bk-clr-fade" id="bt1">
                        <i  class="fa fa-lock dashboard-div-icon"  ></i>
                        <h4>LED 1</h4>
						<h6>CLICK TO TURN ON/OFF</h6>
						
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-6">
                    <div class="dashboard-div-wrapper bk-clr-fade" id="bt2">
                        <i  class="fa fa-fire dashboard-div-icon" ></i>
                        <h4>LED 2</h4>
						<h6>CLICK TO TURN ON/OFF</h6>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-6">
                    <div class="dashboard-div-wrapper bk-clr-fade" id="bt3">
						<i  class="fa fa-bell dashboard-div-icon" ></i>
						<h5>LED 3</h5>
						<h6>CLICK TO TURN ON/OFF</h6>
                    </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-6">
                    <div class="dashboard-div-wrapper bk-clr-fade" id="bt4">
                       <i  class="fa fa-power-off dashboard-div-icon" ></i>
                       <h4>LED 4</h4>
					   <h6>CLICK TO TURN ON/OFF</h6>
                    </div>
                </div>

            </div>
			       
        </div>
    </div>
	<script>
		var 
		$("#bt1").click(function() {
		$(this).toggleClass("bk-clr-one");
		});
		
		$("#bt2").click(function() {
		$(this).toggleClass("bk-clr-two");
		});
		
		$("#bt3").click(function() {
		$(this).toggleClass("bk-clr-three");
		});
		
		$("#bt4").click(function() {
		$(this).toggleClass("bk-clr-four");
		});
		
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/paho-mqtt/1.0.1/mqttws31.min.js" type="text/javascript"></script>
<script src="led123.js"></script>

    <!-- CONTENT-WRAPPER SECTION END-->
   <?php include "footer.php" ?>
  
