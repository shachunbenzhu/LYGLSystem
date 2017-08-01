// --列头全选框被单击---
		function ChkAllClick(sonName , cbAllId) {
			var arrSon = document.getElementsByName(sonName) ;
			var cbAll = document.getElementById(cbAllId) ;
			
			var tempState = cbAll.checked ;
			for(i = 0; i < arrSon.length; i++) {
				if(arrSon[i].checked != tempState) {
					arrSon[i].click() ;
				}
			}
			return false ;
		}
		
		// --子项复选框被单击---
		function ChkSonClick(sonName, cbAllId , buttonname,saveButName) {
			var arrSon = document.getElementsByName(sonName);
			var cbAll = document.getElementById(cbAllId);
			
			// 查看选中的项的个数 
			var num = 0 ; 
			var buttonId = document.getElementById(buttonname) ;
			var saveButton = document.getElementById(saveButName) ;
			
			//alert(arrSon.length) ;
			
			for(var i=0; i<arrSon.length; i++) {
				//alert(i) ;
				//alert(arrSon[i].checked) ;
				if(!arrSon[i].checked) {
					cbAll.checked = false;
				} else {
					num++ ;	
				}
			}
			cbAll.checked = true;
			  
			if (num == 0) {
				buttonId.disabled = true ;
				saveButton.disabled = true ;
				alert("您未勾选任何选项！") ;
				return false ;
			} else if (num == 1) {
				buttonId.disabled = false ;				// 可以点击此按钮
				saveButton.disabled = false ;
				return false ;
			} else {
				buttonId.disabled = true ;
				saveButton.disabled = true ;
				alert("您只可以勾选一项！") ;
				return false ;
			}
			
			
			
		}
		
		// --反选被单击---
		function ChkOppClick(sonName){
			var arrSon = document.getElementsByName(sonName);
			//alert(arrSon.length) ;
			for(var i = 0; i < arrSon.length; i++) {
				//alert(i) ;
				arrSon[i].click();
			}
			return false;
		}