// Set Greeting of the day based on the time of the day
$(document).ready(function () {
  const greetingElement = $("#dynamic-greeting");
  if (greetingElement.length) {
    const hours = new Date().getHours();
    if (hours < 12) {
      greetingElement.text("Good morning! Pamper your pets with us.");
    } else if (hours < 18) {
      greetingElement.text("Good afternoon! Give your pets a spa day.");
    } else {
      greetingElement.text("Good evening! Book a session for your furry friend.");
    }
  }

  // Handle Appointment Form Submission
  $("#appointmentForm").submit(function (e) {
    e.preventDefault();

    
    let isValid = true;
    let errorMessage = "";

    // Dynamically validate all input and select fields
    $("#appointmentForm input, #appointmentForm select").each(function () {
      if (!$(this).val()) {
        isValid = false;
        const fieldName = $(this).attr("name") || "Field";
        errorMessage += `${fieldName.charAt(0).toUpperCase() + fieldName.slice(1)} is required.\n`;
      }
    });

    // Additional validation for specific fields
    const name = $.trim($("#name").val());
    const email = $.trim($("#email").val());
    if (name && !/^[a-zA-Z\s]+$/.test(name)) {
      isValid = false;
      errorMessage += "Name should only contain letters and spaces.\n";
    }
    if (email && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
      isValid = false;
      errorMessage += "Please enter a valid email address.\n";
    }

    // Show error messages if validation fails
    if (!isValid) {
      alert(errorMessage);
      return;
    }

    // Get all selected checkboxes for additional services
    const selectedServices = [];
    $("input[name='services']:checked").each(function () {
      selectedServices.push($(this).val());
    });

    // Display confirmation message 
    const confirmationMessage = $("#confirmationMessage");
    if (confirmationMessage.length) {
      confirmationMessage.html(
        `Thank you, ${name}! We’ve received your booking for a <b>${$("#service").val().replace("-", " ")}</b> for your <b>${$("#pet").val()}</b>. ` +
        `Additional services selected: <b>${selectedServices.length > 0 ? selectedServices.join(", ") : "None"}</b>. ` +
        `We’ll contact you soon at <b>${email}</b>.`
      );
      confirmationMessage.removeClass("hidden").show();
    }

    // Clear form fields after successful submission
    $("#appointmentForm")[0].reset();
  });

  // Handle Customer Review Form Submission
  $("#reviewForm").submit(function (e) {
    e.preventDefault();

    // Get input values
    const name = $.trim($("#reviewerName").val());
    const email = $.trim($("#reviewerEmail").val());
    const rating = $("#serviceRating").val();
    const review = $.trim($("#reviewText").val());

    // Validate inputs
    let isValid = true;
    let errorMessage = "";

    if (!name) {
      isValid = false;
      errorMessage += "Name is required.\n";
    }
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email || !emailRegex.test(email)) {
      isValid = false;
      errorMessage += "Please enter a valid email address.\n";
    }
    if (!rating) {
      isValid = false;
      errorMessage += "Please select a rating.\n";
    }
    if (!review) {
      isValid = false;
      errorMessage += "Please share your review.\n";
    }

    if (!isValid) {
      alert(errorMessage);
      return;
    }

    // Display confirmation message
    const confirmationMessage = $("#reviewConfirmation");
    if (confirmationMessage.length) {
      confirmationMessage.html(
        `Thank you, ${name}! Your review has been submitted successfully.`
      );
      confirmationMessage.removeClass("hidden").show();
    }

    // Clear form fields after successful submission
    $("#reviewForm")[0].reset();
  });
});
