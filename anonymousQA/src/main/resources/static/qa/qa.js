var ROOT_URL = "http://127.0.0.1:8080/api/qa/";
function today() {
  $("#question").html("");
  $.ajax({
    url: ROOT_URL + "today",
    type: 'get',
    success: function(data){
       var questions = data.data;
       if(questions.length > 0) {
            for(var num = 0 ;num< questions.length;num++){
                $("#question").append(
                "<div class='testimonial-right-content mt-50 wow fadeIn' data-wow-duration='1s' data-wow-delay='0.6s'><div class='testimonial-content-wrapper testimonial-active'>"
                + questions[num] + "</div></div>"
                );
            }
       } else {
            $("#question").append(
             "<div class='testimonial-right-content mt-50 wow fadeIn' data-wow-duration='1s' data-wow-delay='0.6s'><div class='testimonial-content-wrapper testimonial-active'>"
                       + "暂无吐槽</div></div>"
             );
       }

    },
    error: function(){
        alert("请稍后重试");
    }
  })
};

function currentMonth() {

$("#question").html("");
  $.ajax({
    url: ROOT_URL + "currentMonth",
    type: 'get',
    success: function(data){
          var questions = data.data;
          if(questions.length > 0) {
               for(var num = 0 ;num< questions.length;num++){
                   $("#question").append(
                   "<div class='testimonial-right-content mt-50 wow fadeIn' data-wow-duration='1s' data-wow-delay='0.6s'><div class='testimonial-content-wrapper testimonial-active'>"
                   + questions[num] + "</div></div>"
                   );
               }
          } else {
            $("#question").append(
                "<div class='testimonial-right-content mt-50 wow fadeIn' data-wow-duration='1s' data-wow-delay='0.6s'><div class='testimonial-content-wrapper testimonial-active'>"
                + "暂无吐槽</div></div>"
             );
          }
    },
    error: function(){
        alert("请稍后重试");
    }
  })
};

function total() {
  $("#question").html("");
  $.ajax({
    url: ROOT_URL + "total",
    type: 'get',
    success: function(data){
              var questions = data.data;
              if(questions.length > 0) {
                   for(var num = 0 ;num< questions.length;num++){
                       $("#question").append(
                       "<div class='testimonial-right-content mt-50 wow fadeIn' data-wow-duration='1s' data-wow-delay='0.6s'><div class='testimonial-content-wrapper testimonial-active'>"
                       + questions[num] + "</div></div>"
                       );
                   }
              } else {
                $("#question").append(
                    "<div class='testimonial-right-content mt-50 wow fadeIn' data-wow-duration='1s' data-wow-delay='0.6s'><div class='testimonial-content-wrapper testimonial-active'>"
                    + "暂无吐槽</div></div>"
                );
              }
    },
    error: function(){
        alert("请稍后重试");
    }
  })
};

 function save() {
    $.ajax({
        url: ROOT_URL + "/newQuestion?question=" + $("#advice").val(),
        type: 'post',
        success: function(data){
            console.log(data);
            alert("提交成功");
            $("#advice").val();
        },
        error: function(){
            alert("请稍后重试");
        }
     })
 };
