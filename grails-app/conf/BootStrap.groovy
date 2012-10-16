import grails.util.GrailsUtil


class BootStrap {

    def init = { servletContext ->
		switch(GrailsUtil.environment){
			case "development":
    	//if (!hascstudy.Hospital.count()) 
    	//{
    	def hospital = new hascstudy.Hospital(hospitalName:"Hospital1")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital2")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital3")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital4")
        hospital.save()
        hospital = new hascstudy.Hospital(hospitalName:"Hospital5")
        hospital.save()
        //}
        
        //if (!hascstudy.Quarter.count()) 
    	//{
		def quarter = new hascstudy.Quarter(quarter:"Quarter1")
        quarter.save()

        quarter = new hascstudy.Quarter(quarter:"Quarter1")
        quarter.save()

        quarter = new hascstudy.Quarter(quarter:"Quarter1")
        quarter.save()
		
		
		def graphtype = new hascstudy.GraphType(name:"Graph Type 1")
		graphtype.save()

		graphtype = new hascstudy.GraphType(name:"Graph Type 2")
		graphtype.save()

		graphtype = new hascstudy.GraphType(name:"Graph Type 3")
		graphtype.save()

		def reportCategory = new hascstudy.ReportCategory(name:"Category 1")
		reportCategory.save()

		reportCategory = new hascstudy.ReportCategory(name:"Category 2")
		reportCategory.save()

		reportCategory = new hascstudy.ReportCategory(name:"Category 3")
		reportCategory.save()

		def admin = new hascstudy.User(login:"admin",
			password:"password",
			name:"Administrator",
			role:"admin")
			admin.save()
		
		def jdoe = new hascstudy.User(login:"jdoe",
				   password:"password",
				   name:"John Doe",
				   role:"author")
				jdoe.save()
		//snip...
		
		def jsmith = new hascstudy.User(login:"jsmith",
				   password:"wordpass",
				   name:"Jane Smith",
				   role:"author")
		jsmith.save()
		//snip...
		
		break
		
		case "production":
		break
		
		
		        //}
	}
	}
    def destroy = {
    }
}
