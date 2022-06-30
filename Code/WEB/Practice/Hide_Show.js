            /*var bDisplay=true;
            function resetDisplay(){
                var con = document.getElementById("reset");
                if(con.style.display!='none'){
                    con.style.display='none';
                }
            }
            function firstDisplay(){
                var con = document.getElementById("first");
                if(con.style.display=='none'){
                    con.style.display='block';
                }else{
                    con.style.display='none';
                }
            }
            function secondDisplay(){
                var con = document.getElementById("second");
                if(con.style.display=='none'){
                    con.style.display='block';
                }else{
                    con.style.display='none';
                }
            }
            function thirdDisplay(){
                var con = document.getElementById("third");
                if(con.style.display=='none'){
                    con.style.display='block';
                }else{
                    con.style.display='none';
                }
            }*/

            function display_on(what){
                var target=document.getElementById('reset');
                target.style.display='block';
                if(what==1)
                {
                    var con = document.getElementById("first");
                    if(con.style.display=='none'){
                        con.style.display='block';
                    }else{
                        con.style.display='none';
                    }
                }
                else if(what==2)
                {
                    var con = document.getElementById("second");
                    if(con.style.display=='none'){
                        con.style.display='block';
                    }else{
                        con.style.display='none';
                    }
                }
                else if(what==3)
                {
                    var con = document.getElementById("third");
                    if(con.style.display=='none'){
                        con.style.display='block';
                    }else{
                        con.style.display='none';
                    }
                }   
            }

            function display_off(){
                var con = document.getElementById("reset");
                var con1 = document.getElementById("first");
                var con2 = document.getElementById("second");
                var con3 = document.getElementById("third");
                con.style.display='none';
                con1.style.display='none';
                con2.style.display='none';
                con3.style.display='none';
            }