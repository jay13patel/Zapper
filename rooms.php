<?php
$page = "Rooms";
include "header.php";
?>
	<div class="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="page-head-line">Rooms</h4>
                </div>
            </div>
           
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-4">
                    <div class="dashboard-div-wrapper bk-clr-one">
                        <h4>SMOKE READING</h4>
						<b><div style="font-size:25px;" id="smoke"></div><b>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-4">
                    <div class="dashboard-div-wrapper bk-clr-two">
                        <h4>TEMPERATURE READING</h4>
						<b><div style="font-size:25px;" id="temp"></div><b>
                    </div>
                </div>
				<div class="col-md-4 col-sm-4 col-xs-4">
                    <div class="dashboard-div-wrapper bk-clr-three" >
                        <h4>HUMIDITY READING</h4>
						<b><div style="font-size:25px;"id="humidity"></div><b>
                    </div>
                </div>

            </div>
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="dashboard-div-livestream bk-clr-fade" id="bt4" data-value="0">
                       <h2>LIVE STREAM</h2>
					   <h5>CLICK TO TURN ON/OFF</h5>
                    </div>
					<div id="livestream"></div>
				</div>
			</div>         
        </div>
	</div>
	<script>
		$("#bt4").click(function(){
		$(this).toggleClass("bk-clr-four");
		if($(this).attr("data-value")==0){
			$("#livestream").load("test.php")
			$(this).attr("data-value","1")
		}
		else{
			$("#livestream").empty();
			$(this).attr("data-value","0");
		}
		});
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/paho-mqtt/1.0.1/mqttws31.min.js" type="text/javascript"></script>
<script src="room.js"></script>




    <!-- CONTENT-WRAPPER SECTION END-->
 
  
<?php include "footer.php" ?>