# TradeSystem
Implement Controller and View layers using Spring MVC for Trade System. It should contain next components and pages

Login (2 inputs, link on the registration page and submit button)
Registration page with 2 inputs and select box (roles) and submit button
View for purchase with list of goods (CRUD operations)
View for Orders with list of all goods from all purchases with order button
View for delivery with all goods was ordered from all order. We can change status of delivery

Implement CRUD operation for all entities via services
Spring should be configured via XML or Java-based config and web.xml should be removed
Use JDBC for communication with database
JSP pages and other layers should support search, sort, pagination operations.
Introduce i18n: support RU and EN languages
Use a template solution: Tiles or Thymeleaf
Prepare validation solution for incorrect input (based on JSR-303 Form Validation)
At least one entity should have image field. Your app can provide possibility to upload/download image and display it.
try to use ThemeResolver, prepare 2 themes
handle exception correctly
use cookies to track something (like username or special counter of views) during the session
