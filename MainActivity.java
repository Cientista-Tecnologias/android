package com.example.ac.nyw;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ac.nyw.resources.BuscarProdutosAsync;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
//===================================================================================
        BuscarProdutosAsync async = new BuscarProdutosAsync(this);
        async.execute();
//==================================================================================================
       /*// Instanciando a ListView...
        String[]items = {"Pizaria Atlântico", "Habbis", "Camarão","Bobs","Chinês","Atlântico","Habbis","Camarão","Bobs","Chinês","Pizzaria"};
        // Instanciando a ListView...
        ListView listview = (ListView) findViewById(R.id.listViewRestaurantes);
        // Inicializando o adapter...
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        // Definindo o adapter (com os dados) para a ListView...
        listview.setAdapter(itemsAdapter);*/
//==================================================================================================
        //Chama o tela de navagação a esquera ou direita
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //navegação da esquerda
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);
        //navegação da direita
        NavigationView navigationView3 = (NavigationView) findViewById(R.id.nav_view2);
        navigationView3.setNavigationItemSelectedListener(this);
    }
//==================================================================================================
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //==================================================================================================
    //primeira parte fica em configurações
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.zero_main, menu);
        //getLayoutInflater().inflate(R.layout.nav_header_main2,mViewPager,)
        return true;

    }
    //segunda parte da configuração (três pontos)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //==================================================================================================*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //=======================================================================

        if (id == R.id.login) {
            // Handle the camera action
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.inicio) {
            ////usando o Intent por que quero que vem a atividade
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.termosecondicoes) {
            Intent intent = new Intent(this,Termos.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.faleconosco) {
            setContentView(R.layout.n1_faleconosco);
            return true;
        } else if (id == R.id.adm) {
            setContentView(R.layout.login);
            return true;
        } else {

            switch (item.getItemId()) {
                //as opções do termo de condições
                case R.id.Entrega:
                    break;
                case R.id.Reserva:
                    break;
                case R.id.Reserva1:
                    break;
                case R.id.Reserva2:
                    break;
                case R.id.Relevancia:
                    break;
                case R.id.Cozinha:
                    break;
                case R.id.Pagamento:
                    break;
            }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        //======================================================================
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //==============================================================================================
    //Instacia os fragmentos para a visualizaçao
    public static class PlaceholderFragment extends Fragment {
        //Instacia os numeros dos fragmentos
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }
        //retorna o fragmento com seu respectivo número
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        //==========================================================================================
        //Chama as telas lista_restaurantes ou lista_promoçoes

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.l_restaurantes, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.l_restaurantes, container, false);
                    return rootView;
                case 2:
                    rootView = inflater.inflate(R.layout.l_promocoes, container, false);
                    return rootView;
            }
            return null;
        }
    }
//==================================================================================================
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "RESTAURANTES";
                case 1:
                    return "PROMOÇÕES";
                //case 2:
                  //return "SECTION 3";
            }
            return null;
        }
    }

    //==============================================================================================
    //TODAS AS FUNÇÕES
    //==============================================================================================
    //Função Alterar endereço atual*/
    //public void novo_end (View view){setContentView(R.layout.activity_main);}
    //public void startSecondActivity(View view) {

        //Intent secondActivity = new Intent(this, Gps.class);
        //startActivity(Gps);
    //}

    //Função Alterar endereço para um novo endereço*/
    public void alterar_end(View view) {
        setContentView(R.layout.localizacao);
    }

    //Função Entrar no Login*/======================================================================
    public void login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    //Função Pesquisa Principal*/===================================================================
    public void pesquisa_p(View view) {
        setContentView(R.layout.l_restaurantes);
    }

    //Função Pesquisa no Filtro*/===================================================================
    public void inicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }/////////////////

    //Funçao tela inicial===========================================================================
    public void pesquisa_f(View view) {
        setContentView(R.layout.l_restaurantes);
    }

    //Funçao tela fale conosco=======================================================================
    public void faleconosco(View view) {
        setContentView(R.layout.activity_main);
    }

    //Função carrinho================================================================================
    public void carrinho(View view) {
        char compra = 'F';
        //  if(R.id.button!=F){
        int compras = R.id.listViewRestaurantes;
        return;
        //}
    }
    //==============================================================================================
}

