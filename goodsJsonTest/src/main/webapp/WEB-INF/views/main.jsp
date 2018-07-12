<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.item {
	border: solid 2px pink;
	/*float: left;*/
	display: inline-block;
	margin: 10px;
	border-radius: 15px;
}

#prev, #next {
	/*float: left;*/
	width: 50;
	display: inline-block;
}

#list {
	display: inline-block;
	margin: 20px 0 0 0px;
}

.cart_item {
	border: solid 2px pink;
	/*float: left;*/
	display: inline-block;
	margin: 10px;
	border-radius: 15px;
}

#cart{
	display: inline-block;
}

#order{
	display: inline-block;
	margin-right: 50px;
}

#orderBtn {
	width: 200px;
	height: 50px;
}
</style>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function() {
	var arr;
	var cart_arr = [];
	
	var pageSIZE = 4;
	var totalRecord = 1;
	var totalPage = 1;
	var currentPage = 1;
	
	//cart에 담길 상품의 인덱스를 증가시키기 위한 변수
	var i = 0;
	
	
	//현재페이지에 보여줄 상품의 노드를 생성한다.
	var mkNode = function() {
		$("#prev").show();
		$("#next").show();
		
		if(currentPage <= 1){
			$("#prev").hide();
		}
		
		if(currentPage >= totalPage){
			$("#next").hide();
		}
		
		$("#list").empty();
		
		var start = (currentPage - 1) * pageSIZE;
		//시작페이지
		var arr2 = arr.slice(start, start + pageSIZE);
		//보이는 상품들
		
		
		$.each(arr2, function(idx, g) {
			var d = $("<div></div>");
			$(d).addClass("cart_item");
			$(d).attr("no", g.no);
			var chk = $("<input></input>").attr("type", "checkbox");
			//$(chk).attr("idx", idx);
			
			$(chk).change(function() {
				var c = $(this).is(":checked");
				
				if(c) {
					var cd = $(d).clone();
					
					$(cd).find(".qty").attr("name", "items["+i+"].qty");
					$(cd).find(".no").attr("name", "items["+i+"].no");
					
					
					var total = eval($("#total").val());
					$("#total").val( total + eval($(cd).find(".price").html()) * eval( $(cd).find(".qty").val() ) );
					
					
					$("#cart").append(cd);
					
					i++;
					
					
					//var idx = $(this).attr("idx");
					//cart_arr.push(arr2[idx]);
				} else {
					var pd = $(this).parent();
					var no = $(pd).attr("no");
					delCart(no);					
				}
			})
			
			$(d).append(chk);
			$("<br>").appendTo(d);
			
			$(d).addClass("item");
			var img = $("<img></img>").attr({
				src: "resources/img/"+g.fname,
				width: "200"
				
			});
			$(d).append(img);
			$("<p></p>").html(g.item).appendTo(d);
			$("<p class='price'></p>").html(g.price).appendTo(d);
			var input_qty = $("<input class='qty' type='number' value='1'>");
			var p_qty = $("<p></p>");
			var span_qty = $("<span></span>").html("("+g.qty+")");
			$(p_qty).append(input_qty, span_qty);
			$(d).append(p_qty);
			
			$("<input class='no' type='number'>").val(g.no).appendTo(d);
			//$("<p></p>").html(g.item).appendTo(d);
			$("#list").append(d);
		});
		
	};//mkNode
	
	//장바구니에서 상품을 삭제하기 위한 함수
	//매개변수로 상품번호를 전달 받아 해당상품을 cart에서 제거했다
	var delCart = function(no) {
		var selArr = $("#cart").find(".item");
		$.each(selArr, function(i, c) {
			var cno = $(c).attr("no");
			if(cno == no) {
				$(c).remove();
				return;
			}
		
		})
		
	};//delCart
	
	
	
	//Ajax통신하여 서버로부터 모든 상품의 목록을 읽어와
	//배열 arr에 담고
	//전체레코드수와 전체페이지를 계산하고 
	//현재페이지(1페이지)에 보여줄 상품노드를 생성하여 보여준다.
	var listGoods = function() {
		$.ajax("listGoods.do", {
			success : function(data) {
				arr = eval("(" + data +")");
				totalRecord = arr.length;
				totalPage = Math.ceil(totalRecord / pageSIZE); 
				//ceil : 올림수
				
				mkNode();
			}
		});
		
	};	//listGoods
	
	listGoods();
	
	//이전페이지를 보여주기 위한 이벤트처리
	$("#prev").click(function() {
		$.ajax("listGoods.do", {
			success: function() {
				currentPage = currentPage - 1;
				mkNode();
			}
		});
	});

	//다음페이지를 보여주기 위한 이벤트처리
	$("#next").click(function() {
		$.ajax("listGoods.do", {
			success: function() {
				currentPage = currentPage + 1;
				mkNode();
			}
		});
	});
	
	/////////////////////////////////////////////////////////////////////
	
		
	
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="prev"><img src="resources/img/left.png"></div>
	<div id="list"></div>
	<div id="next"><img src="resources/img/right.png"></div>
	
	<hr>
	<h3>장바구니</h3>
	<form action="insertOrders.do" method="post">
		<div id="cart"></div>
		아이디 : <input type="text" name="id" value="111"><br>
		배송지 : <input type="text" name="addr"><br>
		총 구매금액 : <input type="text" name="total" id="total" value="0"><br>
		<input type="submit" value="주문">
	</form>
<!-- 
	<div id="order">
		총 구입금액<br>
		<input type="button" id="orderBtn" value="주문하기">
	</div>
 -->
</body>
</html>