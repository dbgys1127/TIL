
        var Link ={
            setColor:function(color){
                var alist =document.querySelectorAll('a');
                var i =0;
                while(i<alist.length){
                alist[i].style.color=color;
                i++;
                }
            }
        }

        var Body = {
            setColor:function(color){
                document.querySelector('body').style.color=color;
            },
            setBackground:function(color){
                document.querySelector('body').style.backgroundColor=color;
            }
        }

        function dayNightHandler(self){
            var target = document.querySelector('body');
            if (self.value==='night'){
            Body.setBackground('black');
            Body.setColor('white');
            self.value='day';
            Link.setColor('yellow');
            } 
            
            else {
            Body.setBackground('white');
            Body.setColor('black'); 
            self.value='night';
            Link.setColor('blue');
            }
        }
    