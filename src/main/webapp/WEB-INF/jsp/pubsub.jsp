<!DOCTYPE html>
<html>

<style>
.topright {
    position: absolute;
    top: 10px;
    right: 20px;
    background-color:lightgrey;
    font-size: 18px;
    height:350px;
    width: 600px;
    border: 25px solid black;
    border-width: 2px;
}

.publisher {
    position: relative;
    top: 10px;
    left: 20px;
    font-size: 12px;
    background-color: lightgrey;
    width: 470px;
    height:280px;
    border: 25px solid black;
    border-width: 2px;
}


.subscriber {
    position: relative;
    top: 30px;
    left: 20px;
    font-size: 12px;
    background-color: lightgrey;
    width: 470px;
    border: 25px solid black;
    border-width: 2px;
}

.notify {
    position: relative;
    top: 80px;
    right: 200px;
    font-size: 12px;
}

.t1{
background-color:black;
/* width:300px; */
 height:220px;
color:white 
}

</style>

<body>
 <form method="post">
 <div class="publisher">
 <h4>Publisher publishes an event</h4>
<select id="publisherId" name="publisherId">
  <option value="1">Publisher 1</option>
  <option value="2">Publisher 2</option>
  <option value="3">Publisher 3</option>
</select>

<select id="topic" name="topic">
  <option value="Travel Summary">Travel Summary</option>
  <option value="Books">Books</option>
</select>
<p> Message </p>
     <textarea rows="6" cols="60" name="message">
     </textarea> </p>
 <input type="Submit" name="buttonClick" value="Publish" >
 Publisher: ${publish}  
 
 </div>
<div class="subscriber">
<h4>Subscriber subscribes to an event</h4>
<select id="subscriberId" name="subscriberId">
  <option value="1">Subscribe 1</option>
  <option value="2">Subscribe 2</option>
</select>
 <select id="subscriberTopic" name="subscriberTopic">
  <option value="Travel Summary">Travel Summary</option>
  <option value="Books">Books</option>
</select>
<br><br>
<input type="Submit" name="buttonClick" value="Subscribe">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="Submit" name="buttonClick" value="UnSubscribe">
&nbsp;&nbsp;&nbsp;&nbsp;
<textarea name="output" cols="60" rows="7">${subscribe}</textarea>
<br><br>
</div>
<div class="topright">
<h5>Event Notification</h5>
<select id="subscriberId2" name="subscriberId2">
  <option value="1">Subscribe 1</option>
  <option value="2">Subscribe 2</option>
</select>

<input type="Submit" name="buttonClick" value="Logs In">
<br><br>
<textarea class=t1 name="notifications" cols="79">${notification}</textarea>
<br>

</div >
<!-- <div class="notify">
</div> -->
</form>  
 
</body>
</html>
