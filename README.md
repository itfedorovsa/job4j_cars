# job4j_cars

This application is a car sales website with car sales posts (ads). 
User can:
- sign up, log in to profile, update profile data
- post, browse, edit, mark as sold or delete his posts (ads).
- add to his favourites another user's posts
- filter posts by various parameters
If the price has changed, it will be shown in the price history.
If the user hasn't added any photos to post, then a picture "photos coming soon" will be added automatically.
Post controls buttons and "Add to favourite" button are available on the view depending on whether the user is the creator of the post (ad).
The publication time is displayed according to the user's time zone.

# Used technologies

Implemented with:
<ul>
 <li>JDK 17</li>
 <li>Maven 3.8.5</li>
 <li>Spring Boot 2.5.2</li>
 <li>JDBC 4</li>
 <li>Lombok 1.18.22</li>
 <li>Bootstrap 4.4.1</li>
 <li>Thymeleaf 2.7.3</li>
 <li>PostgreSQL 42.2.16</li>
 <li>Liquibase 3.6.2</li>
</ul>

# Environment requirements

<ul>
 <li>Create db "cars". Login: postgres, password: password</li>
 <li>Create .jar file via maven command "mvn package"</li>
 <li>Go to the Target folder and check the presence of "job4j_cars-1.0-SNAPSHOT.jar" file</li>
 <li>Open the command line, go to the Target folder</li>
 <li>Run this file through "java -jar job4j_cars-1.0-SNAPSHOT.jar" command</li>
 <li>Then go to the http://localhost:8080/index page</li>
</ul>

# Screenshots

- Sign up page:
  ![Sign up page](src/main/resources/app_screenshots/1_sign_up.png)
- Failed sign up:
  ![Failed sign up](src/main/resources/app_screenshots/2_failed_sign_up.png)
- Successful sign up:
  ![Successful sign up](src/main/resources/app_screenshots/3_successful_sign_up.png)
- Log in page:
  ![Log in page](src/main/resources/app_screenshots/4_login_page.png)
- Failed log in:
  ![Failed log in](src/main/resources/app_screenshots/5_failed_log_in.png)
- Index page:
  ![Index page](src/main/resources/app_screenshots/6_index_page.png)
- All posts page:
  ![All posts page](src/main/resources/app_screenshots/7_all_posts_page.png)
- Select brand on car adding page:
  ![Select brand on car adding page](src/main/resources/app_screenshots/8_add_car_select_brand_page.png)
- Car adding page:
  ![Car adding page](src/main/resources/app_screenshots/9_car_adding_page.png)
- Added post showing page:
  ![Added post showing page](src/main/resources/app_screenshots/10_show_added_post_page.png)
- Autoadding "photos coming soon" picture if added post don't have any photos:
  ![Autoadding "photos coming soon" picture if added post don't have any photos:](src/main/resources/app_screenshots/11_if_added_post_dont_have_any_photos.png)
- Added post shows in all posts:
  ![Added post shows in all posts](src/main/resources/app_screenshots/12_new_post_shows_in_all_posts.png)
- Posts published by user:
  ![Posts published by user](src/main/resources/app_screenshots/13_posts_published_by_user.png)
- Posts added for last day:
  ![Posts added for last day](src/main/resources/app_screenshots/14_posts_added_for_last_day.png)
- Adding another user's post to favourites:
  ![Adding another user's post to favourites](src/main/resources/app_screenshots/15_add_another_users_post_to_favourites.png)
- User favourites:
  ![User favourites](src/main/resources/app_screenshots/16_user_favourites.png)
- Filters page (every filter works individual):
  ![Filters page (every filter works individual)](src/main/resources/app_screenshots/17_filters_page.png)
- Posts filtered by SUV body style:
  ![Posts filtered by SUV body style](src/main/resources/app_screenshots/18_filtered_by_suv.png)
- Published post options (relogged as another user):
  ![Published post options (relogged as another user)](src/main/resources/app_screenshots/19_published_post_options.png)
- Post updating page:
  ![Post updating page](src/main/resources/app_screenshots/20_post_updating_page.png)
- Updated post showing page (with price history):
  ![Updated post showing page (with price history)](src/main/resources/app_screenshots/21_updated_post_showing_page.png)
- Post marked as sold:
  ![Post marked as sold](src/main/resources/app_screenshots/22_post_marked_as_sold.png)
- Post options after marked as sold:
  ![Post options after marked as sold](src/main/resources/app_screenshots/23_post_options_after_marked_as_sold.png)
- All posts after deleting Toyota post:
  ![All posts after deleting Toyota post](src/main/resources/app_screenshots/24_all_posts_after_deleting_toyota_post.png)
- User profile:
  ![User profile](src/main/resources/app_screenshots/25_user_profile.png)
- User profile updating page:
  ![User profile updating page](src/main/resources/app_screenshots/26_user_updating_page.png)

Contact me: itfedorovsa@gmail.com

