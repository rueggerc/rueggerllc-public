<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/jsp/bootstrap.jsp"/>
	<title>Code</title>
</head>


<body>
<div style="margin-left:10px">

<script>
	$(function() {
		$('pre code').each(function(i,block) {
			hljs.highlightBlock(block);
		});
	});
</script>

<H1>Some Java Code</H1>
<div style="width:80%">

<div class="well">
	<strong>Important!</strong>
	<div style="margin-top:2px"></div>
	Make sure your code works!
</div>

<div style="margin-top:2px"></div>
<h3>1. Write the Config File</h3>
<div style="margin-top:2px"></div>
<h4>Foo.xml</h4>
<div>
<pre>
<code class="language-xml">
&lt;foo&gt;Here is some Data&lt;/foo&gt;
</code>
</pre>
</div>


<div style="margin-top:2px"></div>
<h3>1. Write the Foo class</h3>
<div style="margin-top:2px"></div>
<h4>Foo.java</h4>
<div>
<pre>
<code class="language-java">

public class Foo {
  public void execute(String arg) {
  	System.out.println("foobar");
  }
}
</code>
</pre>
</div>

<div style="margin-top:2px"></div>
<h3>2. Write the Bar class</h3>
<p>We have to make some tweeks to this class so that it works properly. First make  sure that
you implement a method called execute. Remember to use the right jar files!
</p>

<div style="margin-top:2px"></div>
<h4>Bar.java</h4>
<div>
<pre>
<code class="language-java">

public class Bar {
  public void execute(String arg) {
  	System.out.println("foobar");
  }
}
</code>
</pre>
</div>

</div>
</div>
</body>
</html>