const quantity = document.querySelector("#quantity");
const street = document.querySelector("#street");
const city = document.querySelector("#city");
const zipCode = document.querySelector("#zipCode");
const phoneNumber = document.querySelector("#phoneNumber");
const pickUpDate = document.querySelector("#pickUpDate");
const pickUpTime = document.querySelector("#pickUpTime");
const pickUpComment = document.querySelector("#pickUpComment");

const Button1Next = document.querySelector("#Button1Next");
const Button2Prev = document.querySelector("#Button2Prev");
const Button2Next = document.querySelector("#Button2Next");
const Button3Prev = document.querySelector("#Button3Prev");
const Button3Next = document.querySelector("#Button3Next");
const Button4Prev = document.querySelector("#Button4Prev");
const Button4Next = document.querySelector("#Button4Next");

function getSelectedCheckboxValues(name) {
    const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
    let values = [];
    checkboxes.forEach((checkbox) => {
        values.push(checkbox.value);
    });
    return values;
}

function getSelectedCheckbox3rdSiblingValues(name) {
    const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
    let values = [];
    checkboxes.forEach((checkbox) => {
        values.push(checkbox.nextElementSibling.nextElementSibling.nextElementSibling.innerText);
    });
    return values;
}

function getSelectedCheckbox2ndSibil1ChildVal(name) {
    const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
    let values = [];
    checkboxes.forEach((checkbox) => {
        values.push(checkbox.nextElementSibling.nextElementSibling.firstElementChild.innerText);
    });
    return values;
}

Button1Next.addEventListener("click", () => {
    if (getSelectedCheckboxValues("categories").length === 0) {
        alert("Please select at least one category!");
        Button2Prev.click();
        return false;
    }
});

Button2Next.addEventListener("click", () => {
    if (quantity.value <= 0) {
        alert("Please enter a proper value!");
        quantity.value = "";
        quantity.focus();
        Button3Prev.click();
        return false;
    }
});

Button3Next.addEventListener("click", () => {
    if (getSelectedCheckboxValues("institution").length === 0) {
        alert("Please select an institution!");
        Button4Prev.click();
        return false;
    }
});

function checkDate() {
    if (new Date(pickUpDate.value) <= new Date()) {
        alert("Pick up date must be in the future!");
        pickUpDate.value = "";
        pickUpDate.focus();
    }
}

function checkTime() {
    if (new Date(pickUpDate.value) === new Date()) {
        if (new Date(pickUpTime.value).getTime() <= new Date().getTime()) {
            alert("Pick up time must be in the future!");
            pickUpTime.value = "";
            pickUpTime.focus();
        }
    }
}

function checkPhoneNrPattern(phoneNumber) {
    var reg = /(\+?[1-9]{2})?(\ )?[0-9]{2,3}(\ )?[0-9]{2,3}(\ )?[0-9]{2,3}/;
    var OK = reg.test(phoneNumber.value);
    if (!OK) {
        window.alert("phone number isn't valid");
        phoneNumber.value = "";
        phoneNumber.focus();
    }
}

function checkZipCodePattern(zipCode) {
    var reg = /([1-9]{2})([-\ ])?[0-9]{3}/;
    var OK = reg.test(zipCode.value);
    if (!OK) {
        window.alert("Zip code isn't valid");
        zipCode.value = "";
        zipCode.focus();
    }
}

Button4Next.addEventListener("click", () => {
    document.querySelector("#summQuantity").innerHTML = quantity.value;
    document.querySelector("#summCategories").innerHTML = getSelectedCheckbox3rdSiblingValues("categories");
    document.querySelector("#summInstitutionName").innerHTML = getSelectedCheckbox2ndSibil1ChildVal("institution");
    document.querySelector("#summPickupStreet").innerHTML = street.value;
    document.querySelector("#summPickupCity").innerHTML = city.value;
    document.querySelector("#summPickupZipCode").innerHTML = zipCode.value;
    document.querySelector("#summPhone").innerHTML = phoneNumber.value;
    document.querySelector("#summPickupDate").innerHTML = pickUpDate.value;
    document.querySelector("#summPickupTime").innerHTML = pickUpTime.value;
    document.querySelector("#summPickUpComment").innerHTML = pickUpComment.value;

    if (street.value.length === 0) {
        alert("Please enter a street name!");
        street.focus();
        step4BtnPrev.click();
        return false;
    }
    if (city.value.length === 0) {
        alert("Please enter a city name!");
        city.focus();
        step4BtnPrev.click();
        return false;
    }

    if (zipCode.value.length === 0) {
        alert("Please enter a zip code!");
        zipCode.focus();
        step4BtnPrev.click();
        return false;
    }

    if (phoneNumber.value.length === 0) {
        alert("Please enter a phone number!");
        phoneNumber.focus();
        step4BtnPrev.click();
        return false;
    }

    if (pickUpDate.value.length === 0) {
        alert("Please enter a proper pick up date!");
        pickUpDate.focus();
        step4BtnPrev.click();
        return false;
    }

    if (pickUpTime.value.length === 0) {
        alert("Please enter a pick up time!");
        pickUpTime.focus();
        step4BtnPrev.click();
        return false;
    }
})