public class Books extends LeafDecorator{
    private String[] options ;


    public Books(String d )
    {
        super(d) ;
    }

    public void setOptions( String[] options )
    {
        this.options = options ;
        for ( int i = 0; i<options.length; i++ )
        {
            if ( "1st edition.".equals(options[i]) )
                this.price += 19.00 ;
            if ( "2nd edition.".equals(options[i]) )
                this.price += 21.50 ;
            if ( "3rd edition.".equals(options[i]) )
                this.price += 25.50 ;
            if (
                    "Original Copy".equals(options[i]) )
                this.price += 31.50 ;
        }
    }

    public String getDescription()
    {
        String desc = "" ;
        for ( int i = 0; i<options.length; i++ )
        {
            if (i>0) desc += " + " + options[i] ;
            else desc = options[i] ;
        }
        return desc ;
    }
}
