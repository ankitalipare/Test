Feature: CartPage
Scenario: Verify total price reflecting correctly if user add item to cart
	Then enter text on search box "shoe for women"
	And select product
	And select size
	Then click on ADD TO BAG button
	Then click on GO TO BAG button
	And select quantity
	Then click update button