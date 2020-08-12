function addStrength() {
	var userInput;
	Swal.mixin({
		input: "text",
		confirmButtonText: "Next &rarr;",
		showCancelButton: true
	})
		.queue([
			{
				title: "Strength",
				text: "Insert new strength"
			}
		])
		.then(result => {
			if (result.value && result.value != "") {
				userInput = result.value;
				const answers = userInput;
				Swal.fire({
					title: "Noted!",
					timer: 1000,
					html: `
        New Strength:
        <pre><code>${answers}</code></pre>
      `,
					confirmButtonText: "Right On!"
				});
				document.querySelector("#strengthArea").style.height = "85%";
				document.querySelector("#strengthArea").innerHTML +=
					'<div contenteditable="true" class="strong-thing">' +
					userInput +
					'<button type="button" class="remove" contenteditable="false">X</button></div>';

				bindBtns();
				document.getElementById("sPlus").style.height = "12%";
				document.querySelector("#sPlus i:nth-child(1)").style.left = "90%";
				document.querySelector("#sPlus i:nth-child(1)").style.width = "3%";
				document.querySelector("#sPlus i:nth-child(2)").style.left = "90%";
				document.querySelector("#sPlus i:nth-child(2)").style.height = "20%";
				document.querySelector("#sPlus i:nth-child(2)").style.width = "10%";
			}
		});
}

function addWeakness() {
	var userInput;
	Swal.mixin({
		input: "text",
		confirmButtonText: "Next &rarr;",
		showCancelButton: true
	})
		.queue([
			{
				title: "Weakness",
				text: "Insert new weakness"
			}
		])
		.then(result => {
			if (result.value && result.value != "") {
				userInput = result.value;
				const answers = userInput;
				Swal.fire({
					title: "Noted!",
					html: `
        New Weakness:
        <pre><code>${answers}</code></pre>
      `,
					confirmButtonText: "Right On!"
				});
				document.querySelector("#weaknessArea").style.height = "85%";
				document.querySelector("#weaknessArea").innerHTML +=
					'<div contenteditable="true" class="weak-thing">' +
					userInput +
					'<button type="button" class="remove" contenteditable="false">X</button></div>';

				bindBtns();
				document.getElementById("wPlus").style.height = "12%";
				document.querySelector("#wPlus i:nth-child(1)").style.left = "90%";
				document.querySelector("#wPlus i:nth-child(1)").style.width = "3%";
				document.querySelector("#wPlus i:nth-child(2)").style.left = "90%";
				document.querySelector("#wPlus i:nth-child(2)").style.height = "20%";
				document.querySelector("#wPlus i:nth-child(2)").style.width = "10%";
			}
		});
}

function addOpportunity() {
	var userInput;
	Swal.mixin({
		input: "text",
		confirmButtonText: "Next &rarr;",
		showCancelButton: true
	})
		.queue([
			{
				title: "Opportunity",
				text: "Insert new opportunity"
			}
		])
		.then(result => {
			if (result.value && result.value != "") {
				userInput = result.value;
				const answers = userInput;
				Swal.fire({
					title: "Noted!",
					html: `
        New Opportunity:
        <pre><code>${answers}</code></pre>
      `,
					confirmButtonText: "Right On!"
				});
				document.querySelector("#opportunityArea").style.height = "85%";
				document.querySelector("#opportunityArea").innerHTML +=
					'<div contenteditable="true" class="opp-thing">' +
					userInput +
					'<button type="button" class="remove" contenteditable="false">X</button></div>';

				bindBtns();
				document.getElementById("oPlus").style.height = "12%";
				document.querySelector("#oPlus i:nth-child(1)").style.left = "90%";
				document.querySelector("#oPlus i:nth-child(1)").style.width = "3%";
				document.querySelector("#oPlus i:nth-child(2)").style.left = "90%";
				document.querySelector("#oPlus i:nth-child(2)").style.height = "20%";
				document.querySelector("#oPlus i:nth-child(2)").style.width = "10%";
			}
		});
}

function addThreat() {
	var userInput;
	Swal.mixin({
		input: "text",
		confirmButtonText: "Next &rarr;",
		showCancelButton: true
	})
		.queue([
			{
				title: "Threat",
				text: "Insert new threat"
			}
		])
		.then(result => {
			if (result.value && result.value != "") {
				userInput = result.value;
				const answers = userInput;
				Swal.fire({
					title: "Noted!",
					html: `
        New Threat:
        <pre><code>${answers}</code></pre>
      `,
					confirmButtonText: "Right On!"
				});
				document.querySelector("#threatArea").style.height = "85%";
				document.querySelector("#threatArea").innerHTML +=
					'<div contenteditable="true" class="threat-thing">' +
					userInput +
					'<button type="button" class="remove" contenteditable="false">X</button></div>';

				bindBtns();
				document.getElementById("tPlus").style.height = "12%";
				document.querySelector("#tPlus i:nth-child(1)").style.left = "90%";
				document.querySelector("#tPlus i:nth-child(1)").style.width = "3%";
				document.querySelector("#tPlus i:nth-child(2)").style.left = "90%";
				document.querySelector("#tPlus i:nth-child(2)").style.height = "20%";
				document.querySelector("#tPlus i:nth-child(2)").style.width = "10%";
			}
		});
}

document.getElementById("sPlus").addEventListener("click", addStrength);
document.getElementById("wPlus").addEventListener("click", addWeakness);
document.getElementById("oPlus").addEventListener("click", addOpportunity);
document.getElementById("tPlus").addEventListener("click", addThreat);

function bindBtns() {
	var btn = document.getElementsByClassName("remove");

	for (var i = 0; i < btn.length; i++) {
		btn[i].addEventListener(
			"click",
			function(e) {
				Swal.fire({
					title: "Are you sure?",
					icon: "warning",
					showCancelButton: true,
					confirmButtonColor: "#3085d6",
					cancelButtonColor: "#d33",
					confirmButtonText: "Yes, delete it!"
				}).then(result => {
					if (result.value) {
						Swal.fire("Deleted!", "", "success");
						//remove the thing
						this.parentNode.remove();
					}
				});

				//this.closest('.single').remove() // in modern browsers in complex dom structure
				//this.parentNode.remove(); //this refers to the current target element
				//e.target.parentNode.parentNode.removeChild(e.target.parentNode);
			},
			false
		);
	}
}
