/**
  * Project Name:
  * Project URL: 
  * Author: 
*/
!(function($) {
  "use strict";

  // Smooth scroll for the navigation menu and links with .scrollto classes
  var scrolltoOffset = $('#header').outerHeight() - 1;
  $(document).on('click', '.nav-menu a, .mobile-nav a, .scrollto', function(e) {
    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
      var target = $(this.hash);
      if (target.length) {
        e.preventDefault();

        var scrollto = target.offset().top - scrolltoOffset;

        if ($(this).attr("href") == '#header') {
          scrollto = 0;
        }

        $('html, body').animate({
          scrollTop: scrollto
        }, 1500, 'easeInOutExpo');

        if ($(this).parents('.nav-menu, .mobile-nav').length) {
          $('.nav-menu .active, .mobile-nav .active').removeClass('active');
          $(this).closest('li').addClass('active');
        }

        if ($('body').hasClass('mobile-nav-active')) {
          $('body').removeClass('mobile-nav-active');
          $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
          $('.mobile-nav-overly').fadeOut();
        }
        return false;
      }
    }
  });

  // Activate smooth scroll on page load with hash links in the url
  $(document).ready(function() {
    if (window.location.hash) {
      var initial_nav = window.location.hash;
      if ($(initial_nav).length) {
        var scrollto = $(initial_nav).offset().top - scrolltoOffset;
        $('html, body').animate({
          scrollTop: scrollto
        }, 1500, 'easeInOutExpo');
      }
    }
  });

  // Mobile Navigation
  if ($('.nav-menu').length) {
    var $mobile_nav = $('.nav-menu').clone().prop({
      class: 'mobile-nav d-lg-none'
    });
    $('body').append($mobile_nav);
    $('body').prepend('<button type="button" class="mobile-nav-toggle d-lg-none"><i class="icofont-navigation-menu"></i></button>');
    $('body').append('<div class="mobile-nav-overly"></div>');

    $(document).on('click', '.mobile-nav-toggle', function(e) {
      $('body').toggleClass('mobile-nav-active');
      $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
      $('.mobile-nav-overly').toggle();
    });

    $(document).on('click', '.mobile-nav .drop-down > a', function(e) {
      e.preventDefault();
      $(this).next().slideToggle(300);
      $(this).parent().toggleClass('active');
    });

    $(document).click(function(e) {
      var container = $(".mobile-nav, .mobile-nav-toggle");
      if (!container.is(e.target) && container.has(e.target).length === 0) {
        if ($('body').hasClass('mobile-nav-active')) {
          $('body').removeClass('mobile-nav-active');
          $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
          $('.mobile-nav-overly').fadeOut();
        }
      }
    });
  } else if ($(".mobile-nav, .mobile-nav-toggle").length) {
    $(".mobile-nav, .mobile-nav-toggle").hide();
  }

  // Navigation active state on scroll
  var nav_sections = $('section');
  var main_nav = $('.nav-menu, .mobile-nav');

  $(window).on('scroll', function() {
    var cur_pos = $(this).scrollTop() + 200;

    nav_sections.each(function() {
      var top = $(this).offset().top,
        bottom = top + $(this).outerHeight();

      if (cur_pos >= top && cur_pos <= bottom) {
        if (cur_pos <= bottom) {
          main_nav.find('li').removeClass('active');
        }
        main_nav.find('a[href="#' + $(this).attr('id') + '"]').parent('li').addClass('active');
      }
      if (cur_pos < 300) {
        $(".nav-menu ul:first li:first").addClass('active');
      }
    });
  });

  // Back to top button
  $(window).scroll(function() {
    if ($(this).scrollTop() > 100) {
      $('.back-to-top').fadeIn('slow');
    } else {
      $('.back-to-top').fadeOut('slow');
    }
  });

  $('.back-to-top').click(function() {
    $('html, body').animate({
      scrollTop: 0
    }, 1500, 'easeInOutExpo');
    return false;
  });

  /*Title: Cool Modal Popup Sign In/Out Form*/

// $(function() {
//   //defining all needed variables
//   var $overlay = $('.overlay');
//   var $mainPopUp = $('.main-popup')
//   var $signIn = $('#sign-in');
//   var $register = $('#register');
//   var $formSignIn = $('form.sign-in');
//   var $formRegister = $('form.register');
  
//   var $firstChild = $('nav ul li:first-child');
//   var $secondChild = $('nav ul li:nth-child(2)');
//   var $thirdChild = $('nav ul li:nth-child(3)');
  
//   //defining function to create underline initial state on document load
//   function initialState() {
//     $('.underline').css({
//       "width": $firstChild.width(),
//       "left": $firstChild.position().left,
//       "top": $firstChild.position().top + $firstChild.outerHeight(true) + 'px'
//     });
//   }
//   initialState(); //() used after calling function to call function immediately on doc load
  
//   //defining function to change underline depending on which li is active
//   function changeUnderline(el) {
//     $('.underline').css({
//       "width": el.width(),
//       "left": el.position().left,
//       "top": el.position().top + el.outerHeight(true) + 'px'
//     });
//   } //note: have not called the function...don't want it called immediately
  
//   $firstChild.on('click', function(){
//     var el = $firstChild;
//     changeUnderline(el); //call the changeUnderline function with el as the perameter within the called function
//     $secondChild.removeClass('active');
//     $thirdChild.removeClass('active');
//     $(this).addClass('active');
//   });
  
//   $secondChild.on('click', function(){
//     var el = $secondChild;
//     changeUnderline(el); //call the changeUnderline function with el as the perameter within the called function
//     $firstChild.removeClass('active');
//     $thirdChild.removeClass('active');
//     $(this).addClass('active');
//   });
  
//   $thirdChild.on('click', function(){
//     var el = $thirdChild;
//     changeUnderline(el); //call the changeUnderline function with el as the perameter within the called function
//     $firstChild.removeClass('active');
//     $secondChild.removeClass('active');
//     $(this).addClass('active');
//   });
  
  
//   $('button').on('click', function(){
//     $overlay.addClass('visible');
//     $mainPopUp.addClass('visible');
//     $signIn.addClass('active');
//     $register.removeClass('active');
//     $formRegister.removeClass('move-left');
//     $formSignIn.removeClass('move-left');
//   });
//   $overlay.on('click', function(){
//     $(this).removeClass('visible');
//     $mainPopUp.removeClass('visible');
//   });
//   $('#popup-close-button a').on('click', function(e){
//     e.preventDefault();
//     $overlay.removeClass('visible');
//     $mainPopUp.removeClass('visible');
//   });
  
//   $signIn.on('click', function(){
//     $signIn.addClass('active');
//     $register.removeClass('active');
//     $formSignIn.removeClass('move-left');
//     $formRegister.removeClass('move-left');
//   });
  
//   $register.on('click', function(){
//     $signIn.removeClass('active');
//     $register.addClass('active');
//     $formSignIn.addClass('move-left');
//     $formRegister.addClass('move-left');
//   });
  
//   $('input').on('submit', function(e){
//     e.preventDefault(); //used to prevent submission of form...remove for real use
//   });
// });

  // Testimonials carousel (uses the Owl Carousel library)
  $(".testimonials-carousel").owlCarousel({
    autoplay: true,
    dots: true,
    loop: true,
    responsive: {
      0: {
        items: 1
      },
      768: {
        items: 2
      },
      900: {
        items: 3
      }
    }
  });

 

// Clients carousel (uses the Owl Carousel library)
  $(".clients-carousel").owlCarousel({
    autoplay: true,
    dots: true,
    loop: true,
    responsive: {
      0: {
        items: 2
      },
      768: {
        items: 4
      },
      900: {
        items: 6
      }
    }
  });


 
  // Init AOS
  function aos_init() {
    AOS.init({
      duration: 1000,
      easing: "ease-in-out",
      once: true
    });
  }
  $(window).on('load', function() {
    aos_init();
  });

})(jQuery);

