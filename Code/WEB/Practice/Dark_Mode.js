var Link ={
    setColor:function(color){
        var alist=document.querySelectorAll('a');
        var i=0;
            while(i<alist.length){
                alist[i].style.color=color;
                i++;
            }    
    }
}
var Body ={
    setColor:function(color){
    var target=document.querySelector('body');  
    target.style.color=color;
    },
    setBackgroundColor:function(color){
    var target=document.querySelector('body');  
    target.style.backgroundColor=color;
    }
}
var Border={
    setColor:function(color){
    var border=document.getElementById('grid');
    var border1=document.getElementById('content');
    var border2=document.getElementById('content1');
    var border3=document.getElementById('content2');
    var border4=document.querySelector('h1');
    var border5=document.querySelector('ul');
    border.style.borderBlockColor=color;
    border1.style.borderBottomColor=color;
    border2.style.borderBottomColor=color;
    border3.style.borderBottomColor=color;
    border4.style.borderBlockColor=color;
    border5.style.borderRightColor=color;
    }
}

function dayNightHandler(self){
    
    if(self.value==='night')
    {
        Body.setColor('white');
        Body.setBackgroundColor('black');
        Link.setColor('powderblue');
        Border.setColor('white');
        self.value='day';

    }else{

        
        Body.setColor('black');
        Body.setBackgroundColor('white');
        Link.setColor('black');
        Border.setColor('black');
        self.value='night';
    
    }
}