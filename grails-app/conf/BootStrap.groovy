class BootStrap {

    def init = { servletContext ->
environments {
    development {
    	if (!hascstudy.Hospital.count()) 
    	{
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
        }
        
        if (!hascstudy.Quarter.count()) 
    	{def quarter = new hascstudy.Quarter(quarter:"Quarter1")
        quarter.save()

        quarter = new hascstudy.Quarter(quarter:"Quarter1")
        quarter.save()

        quarter = new hascstudy.Quarter(quarter:"Quarter1")
        quarter.save()
        }
	}
	}
	}
    def destroy = {
    }
}
