$(document).ready(function(){
	
  init();	  
  
 
  $("#sendMsgButton").click(function(){
	  var inputStr = $("#inputText").val();
	  $("#inputText").val("");
	  if(inputStr.length == 0){
		  $("#sendMsgButtonAlert").trigger("click");
	  }
	  else{
		  var customerDate = new Date();
		  var customerDateStr = (customerDate.getMonth()+1)+"-"+customerDate.getDate()+" "+customerDate.getHours()+":"+customerDate.getMinutes()+":"+customerDate.getSeconds();
		  
		  var customerMsg = "<p><b>";
		  customerMsg = customerMsg + $("#customerName").text();
		  customerMsg = customerMsg + "</b>"+" "+customerDateStr+"</p>";
		  customerMsg = customerMsg + "<div><p>";
		  customerMsg = customerMsg + inputStr + "</p></div>";
		  $("#talkWindowCol").append(customerMsg);
		  $("#talkWindow").scrollTop(Number.MAX_VALUE);  
		  $("#inputText").focus();
		  
		  $.post(
				  "getMsg",
				  {
					  customerContent: inputStr
				  },
				  function(data){
					  var robotDate = new Date();
					  var robotDateStr = (robotDate.getMonth()+1)+"-"+robotDate.getDate()+" "+robotDate.getHours()+":"+robotDate.getMinutes()+":"+robotDate.getSeconds();
					  
					  var robotMsg= "<p><b>wgbj006</b> ";
					  robotMsg = robotMsg + robotDateStr;
					  robotMsg = robotMsg + "</p><div><p>";
					  robotMsg = robotMsg + data + "</p></div>";
					  $("#talkWindowCol").append(robotMsg);
					  $("#talkWindow").scrollTop(Number.MAX_VALUE);  
					  $("#inputText").focus();
				  } 
		  );
	   }
  });
});

function init(){
	  var date = new Date();
	  var dateStr = (date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	  
	  var customerMsg = "<div><p>";
	  customerMsg = customerMsg + dateStr+" ";
	  customerMsg = customerMsg + " 万国置地-客服正在和您进行对话..";
	  customerMsg = customerMsg + "<p><b>wgbj006</b> "+ dateStr + "</p><div><p><strong><font>您好！这里是※</font><font>万国置地海外楼市网</font><font>※我是今天的值班客服,很高兴为您服务。如需电话回复请留下联系方式或拨打<font>010-56082403</font>热线电话，帮您解答。</font></strong></p></div>";
	  $("#talkWindowCol").append(customerMsg);
	  $("#talkWindow").scrollTop(Number.MAX_VALUE);  
	  $("#inputText").focus();
}