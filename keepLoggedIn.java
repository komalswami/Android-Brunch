if( auth.getInstance().getCurrentUser()!= null)
        {
            startActivity(new Intent(getApplicationContext(),complain.class));
            finish();
        }
