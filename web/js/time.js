/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    function notify_date(){
        var value;
          $.ajax({
              url:'Date.jsp',
              success:function(data){
                    $('.result1').html(data);
                      value=document.getElementById("value").value;
                },
        complete:function(){
                                if(value>=45){
                    
        window.location.replace("user/TimeFinished.jsp");
       
                   
 }
                    else{
                      setTimeout(notify_date(),1000);
                 }}
             
                  });
              }
                            
         