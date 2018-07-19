<html>
	<body>
		<h1>Welcome to the guessing game. Enter a number between 1 and 100</h1>
		<form action="/play" method="POST">
			Enter your guess<input type="text" name="guess"/><br/>
			<button>Play</button>
			<hr/>
			<h3>${message}</h3>
			<h4>${attempts}</h4>
		</form>
	</body>
</html>