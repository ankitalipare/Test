Feature: Coupon page

Scenario: Verify error message when user enter invalid coupon code
	Then enter text search box "shoes for women"
	And select a product
	And select a size
	Then click on ADD TO BAG 
	Then click on GO TO BAG 
	Then enter coupon code
	And click on apply button  
	Then verify error msg

	
Scenario Outline: To verify coupon codes successfully applied to product
	Then enter text search box "shoes for women"
	And select a product
	And select a size
	Then click on ADD TO BAG 
	Then click on GO TO BAG 
	Then enter coupon code <Codes>
	And click on apply button  
	
Examples:

	|Codes|
	|"SAVE5"|	#pipe
	|"FREESHIP"|
	|"FREEDEL"|