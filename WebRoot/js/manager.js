// --��ͷȫѡ�򱻵���---
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
		
		// --���ѡ�򱻵���---
		function ChkSonClick(sonName, cbAllId , buttonname,saveButName) {
			var arrSon = document.getElementsByName(sonName);
			var cbAll = document.getElementById(cbAllId);
			
			// �鿴ѡ�е���ĸ��� 
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
				alert("��δ��ѡ�κ�ѡ�") ;
				return false ;
			} else if (num == 1) {
				buttonId.disabled = false ;				// ���Ե���˰�ť
				saveButton.disabled = false ;
				return false ;
			} else {
				buttonId.disabled = true ;
				saveButton.disabled = true ;
				alert("��ֻ���Թ�ѡһ�") ;
				return false ;
			}
			
			
			
		}
		
		// --��ѡ������---
		function ChkOppClick(sonName){
			var arrSon = document.getElementsByName(sonName);
			//alert(arrSon.length) ;
			for(var i = 0; i < arrSon.length; i++) {
				//alert(i) ;
				arrSon[i].click();
			}
			return false;
		}