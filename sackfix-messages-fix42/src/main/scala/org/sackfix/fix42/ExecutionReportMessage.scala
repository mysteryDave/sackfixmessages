package org.sackfix.fix42

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX42.xml
  */
case class ExecutionReportMessage(orderIDField:OrderIDField,
                                  secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                  clOrdIDField:Option[ClOrdIDField]=None,
                                  origClOrdIDField:Option[OrigClOrdIDField]=None,
                                  clientIDField:Option[ClientIDField]=None,
                                  execBrokerField:Option[ExecBrokerField]=None,
                                  noContraBrokersField:Option[NoContraBrokersField]=None,
                                  contraBrokersGroups: Option[List[ContraBrokersGroup]]=None,
                                  listIDField:Option[ListIDField]=None,
                                  execIDField:ExecIDField,
                                  execTransTypeField:ExecTransTypeField,
                                  execRefIDField:Option[ExecRefIDField]=None,
                                  execTypeField:ExecTypeField,
                                  ordStatusField:OrdStatusField,
                                  ordRejReasonField:Option[OrdRejReasonField]=None,
                                  execRestatementReasonField:Option[ExecRestatementReasonField]=None,
                                  accountField:Option[AccountField]=None,
                                  settlmntTypField:Option[SettlmntTypField]=None,
                                  futSettDateField:Option[FutSettDateField]=None,
                                  symbolField:SymbolField,
                                  symbolSfxField:Option[SymbolSfxField]=None,
                                  securityIDField:Option[SecurityIDField]=None,
                                  iDSourceField:Option[IDSourceField]=None,
                                  securityTypeField:Option[SecurityTypeField]=None,
                                  maturityMonthYearField:Option[MaturityMonthYearField]=None,
                                  maturityDayField:Option[MaturityDayField]=None,
                                  putOrCallField:Option[PutOrCallField]=None,
                                  strikePriceField:Option[StrikePriceField]=None,
                                  optAttributeField:Option[OptAttributeField]=None,
                                  contractMultiplierField:Option[ContractMultiplierField]=None,
                                  couponRateField:Option[CouponRateField]=None,
                                  securityExchangeField:Option[SecurityExchangeField]=None,
                                  issuerField:Option[IssuerField]=None,
                                  encodedIssuerLenField:Option[EncodedIssuerLenField]=None,
                                  encodedIssuerField:Option[EncodedIssuerField]=None,
                                  securityDescField:Option[SecurityDescField]=None,
                                  encodedSecurityDescLenField:Option[EncodedSecurityDescLenField]=None,
                                  encodedSecurityDescField:Option[EncodedSecurityDescField]=None,
                                  sideField:SideField,
                                  orderQtyField:Option[OrderQtyField]=None,
                                  cashOrderQtyField:Option[CashOrderQtyField]=None,
                                  ordTypeField:Option[OrdTypeField]=None,
                                  priceField:Option[PriceField]=None,
                                  stopPxField:Option[StopPxField]=None,
                                  pegDifferenceField:Option[PegDifferenceField]=None,
                                  discretionInstField:Option[DiscretionInstField]=None,
                                  discretionOffsetField:Option[DiscretionOffsetField]=None,
                                  currencyField:Option[CurrencyField]=None,
                                  complianceIDField:Option[ComplianceIDField]=None,
                                  solicitedFlagField:Option[SolicitedFlagField]=None,
                                  timeInForceField:Option[TimeInForceField]=None,
                                  effectiveTimeField:Option[EffectiveTimeField]=None,
                                  expireDateField:Option[ExpireDateField]=None,
                                  expireTimeField:Option[ExpireTimeField]=None,
                                  execInstField:Option[ExecInstField]=None,
                                  rule80AField:Option[Rule80AField]=None,
                                  lastSharesField:Option[LastSharesField]=None,
                                  lastPxField:Option[LastPxField]=None,
                                  lastSpotRateField:Option[LastSpotRateField]=None,
                                  lastForwardPointsField:Option[LastForwardPointsField]=None,
                                  lastMktField:Option[LastMktField]=None,
                                  tradingSessionIDField:Option[TradingSessionIDField]=None,
                                  lastCapacityField:Option[LastCapacityField]=None,
                                  leavesQtyField:LeavesQtyField,
                                  cumQtyField:CumQtyField,
                                  avgPxField:AvgPxField,
                                  dayOrderQtyField:Option[DayOrderQtyField]=None,
                                  dayCumQtyField:Option[DayCumQtyField]=None,
                                  dayAvgPxField:Option[DayAvgPxField]=None,
                                  gTBookingInstField:Option[GTBookingInstField]=None,
                                  tradeDateField:Option[TradeDateField]=None,
                                  transactTimeField:Option[TransactTimeField]=None,
                                  reportToExchField:Option[ReportToExchField]=None,
                                  commissionField:Option[CommissionField]=None,
                                  commTypeField:Option[CommTypeField]=None,
                                  grossTradeAmtField:Option[GrossTradeAmtField]=None,
                                  settlCurrAmtField:Option[SettlCurrAmtField]=None,
                                  settlCurrencyField:Option[SettlCurrencyField]=None,
                                  settlCurrFxRateField:Option[SettlCurrFxRateField]=None,
                                  settlCurrFxRateCalcField:Option[SettlCurrFxRateCalcField]=None,
                                  handlInstField:Option[HandlInstField]=None,
                                  minQtyField:Option[MinQtyField]=None,
                                  maxFloorField:Option[MaxFloorField]=None,
                                  openCloseField:Option[OpenCloseField]=None,
                                  maxShowField:Option[MaxShowField]=None,
                                  textField:Option[TextField]=None,
                                  encodedTextLenField:Option[EncodedTextLenField]=None,
                                  encodedTextField:Option[EncodedTextField]=None,
                                  futSettDate2Field:Option[FutSettDate2Field]=None,
                                  orderQty2Field:Option[OrderQty2Field]=None,
                                  clearingFirmField:Option[ClearingFirmField]=None,
                                  clearingAccountField:Option[ClearingAccountField]=None,
                                  multiLegReportingTypeField:Option[MultiLegReportingTypeField]=None) extends SfFixMessageBody("8")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noContraBrokersField.map(_.value).getOrElse(0) != contraBrokersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoContraBrokersField.TagId,noContraBrokersField.map(_.value).getOrElse(0), contraBrokersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,orderIDField)
    secondaryOrderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    origClOrdIDField.foreach(fmt(b,_))
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
    noContraBrokersField.foreach(fmt(b,_))
    contraBrokersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    listIDField.foreach(fmt(b,_))
    fmt(b,execIDField)
    fmt(b,execTransTypeField)
    execRefIDField.foreach(fmt(b,_))
    fmt(b,execTypeField)
    fmt(b,ordStatusField)
    ordRejReasonField.foreach(fmt(b,_))
    execRestatementReasonField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    settlmntTypField.foreach(fmt(b,_))
    futSettDateField.foreach(fmt(b,_))
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    iDSourceField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    maturityMonthYearField.foreach(fmt(b,_))
    maturityDayField.foreach(fmt(b,_))
    putOrCallField.foreach(fmt(b,_))
    strikePriceField.foreach(fmt(b,_))
    optAttributeField.foreach(fmt(b,_))
    contractMultiplierField.foreach(fmt(b,_))
    couponRateField.foreach(fmt(b,_))
    securityExchangeField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    encodedIssuerLenField.foreach(fmt(b,_))
    encodedIssuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    encodedSecurityDescLenField.foreach(fmt(b,_))
    encodedSecurityDescField.foreach(fmt(b,_))
    fmt(b,sideField)
    orderQtyField.foreach(fmt(b,_))
    cashOrderQtyField.foreach(fmt(b,_))
    ordTypeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    stopPxField.foreach(fmt(b,_))
    pegDifferenceField.foreach(fmt(b,_))
    discretionInstField.foreach(fmt(b,_))
    discretionOffsetField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    complianceIDField.foreach(fmt(b,_))
    solicitedFlagField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    effectiveTimeField.foreach(fmt(b,_))
    expireDateField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    execInstField.foreach(fmt(b,_))
    rule80AField.foreach(fmt(b,_))
    lastSharesField.foreach(fmt(b,_))
    lastPxField.foreach(fmt(b,_))
    lastSpotRateField.foreach(fmt(b,_))
    lastForwardPointsField.foreach(fmt(b,_))
    lastMktField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    lastCapacityField.foreach(fmt(b,_))
    fmt(b,leavesQtyField)
    fmt(b,cumQtyField)
    fmt(b,avgPxField)
    dayOrderQtyField.foreach(fmt(b,_))
    dayCumQtyField.foreach(fmt(b,_))
    dayAvgPxField.foreach(fmt(b,_))
    gTBookingInstField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    reportToExchField.foreach(fmt(b,_))
    commissionField.foreach(fmt(b,_))
    commTypeField.foreach(fmt(b,_))
    grossTradeAmtField.foreach(fmt(b,_))
    settlCurrAmtField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    settlCurrFxRateField.foreach(fmt(b,_))
    settlCurrFxRateCalcField.foreach(fmt(b,_))
    handlInstField.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    maxFloorField.foreach(fmt(b,_))
    openCloseField.foreach(fmt(b,_))
    maxShowField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    futSettDate2Field.foreach(fmt(b,_))
    orderQty2Field.foreach(fmt(b,_))
    clearingFirmField.foreach(fmt(b,_))
    clearingAccountField.foreach(fmt(b,_))
    multiLegReportingTypeField.foreach(fmt(b,_))
    b
  }

}
     
object ExecutionReportMessage extends SfFixMessageDecoder {
  val MsgType="8"
  val MsgName="ExecutionReport"
             
  override val MandatoryFields = HashSet[Int](
    OrderIDField.TagId, ExecIDField.TagId, ExecTransTypeField.TagId, ExecTypeField.TagId, OrdStatusField.TagId, 
    SymbolField.TagId, SideField.TagId, LeavesQtyField.TagId, CumQtyField.TagId, AvgPxField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ContraBrokersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecondaryOrderIDField.TagId, ClOrdIDField.TagId, OrigClOrdIDField.TagId, ClientIDField.TagId, ExecBrokerField.TagId, 
    NoContraBrokersField.TagId, ListIDField.TagId, ExecRefIDField.TagId, OrdRejReasonField.TagId, ExecRestatementReasonField.TagId, 
    AccountField.TagId, SettlmntTypField.TagId, FutSettDateField.TagId, SymbolSfxField.TagId, SecurityIDField.TagId, 
    IDSourceField.TagId, SecurityTypeField.TagId, MaturityMonthYearField.TagId, MaturityDayField.TagId, PutOrCallField.TagId, 
    StrikePriceField.TagId, OptAttributeField.TagId, ContractMultiplierField.TagId, CouponRateField.TagId, SecurityExchangeField.TagId, 
    IssuerField.TagId, EncodedIssuerLenField.TagId, EncodedIssuerField.TagId, SecurityDescField.TagId, EncodedSecurityDescLenField.TagId, 
    EncodedSecurityDescField.TagId, OrderQtyField.TagId, CashOrderQtyField.TagId, OrdTypeField.TagId, PriceField.TagId, 
    StopPxField.TagId, PegDifferenceField.TagId, DiscretionInstField.TagId, DiscretionOffsetField.TagId, CurrencyField.TagId, 
    ComplianceIDField.TagId, SolicitedFlagField.TagId, TimeInForceField.TagId, EffectiveTimeField.TagId, ExpireDateField.TagId, 
    ExpireTimeField.TagId, ExecInstField.TagId, Rule80AField.TagId, LastSharesField.TagId, LastPxField.TagId, 
    LastSpotRateField.TagId, LastForwardPointsField.TagId, LastMktField.TagId, TradingSessionIDField.TagId, LastCapacityField.TagId, 
    DayOrderQtyField.TagId, DayCumQtyField.TagId, DayAvgPxField.TagId, GTBookingInstField.TagId, TradeDateField.TagId, 
    TransactTimeField.TagId, ReportToExchField.TagId, CommissionField.TagId, CommTypeField.TagId, GrossTradeAmtField.TagId, 
    SettlCurrAmtField.TagId, SettlCurrencyField.TagId, SettlCurrFxRateField.TagId, SettlCurrFxRateCalcField.TagId, HandlInstField.TagId, 
    MinQtyField.TagId, MaxFloorField.TagId, OpenCloseField.TagId, MaxShowField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId, FutSettDate2Field.TagId, OrderQty2Field.TagId, ClearingFirmField.TagId, 
    ClearingAccountField.TagId, MultiLegReportingTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ContraBrokersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ContraBrokersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoContraBrokersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ExecutionReportMessage(OrderIDField.decode(myFields.get(OrderIDField.TagId)).get,
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(OrigClOrdIDField.TagId).flatMap(f=>OrigClOrdIDField.decode(f)),
        myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
        myFields.get(NoContraBrokersField.TagId).flatMap(f=>NoContraBrokersField.decode(f)),
        if (nextTagPosLookup.contains(NoContraBrokersField.TagId)) ContraBrokersGroup.decode(flds, nextTagPosLookup(NoContraBrokersField.TagId)) else None,
        myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
        ExecIDField.decode(myFields.get(ExecIDField.TagId)).get,
        ExecTransTypeField.decode(myFields.get(ExecTransTypeField.TagId)).get,
        myFields.get(ExecRefIDField.TagId).flatMap(f=>ExecRefIDField.decode(f)),
        ExecTypeField.decode(myFields.get(ExecTypeField.TagId)).get,
        OrdStatusField.decode(myFields.get(OrdStatusField.TagId)).get,
        myFields.get(OrdRejReasonField.TagId).flatMap(f=>OrdRejReasonField.decode(f)),
        myFields.get(ExecRestatementReasonField.TagId).flatMap(f=>ExecRestatementReasonField.decode(f)),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(SettlmntTypField.TagId).flatMap(f=>SettlmntTypField.decode(f)),
        myFields.get(FutSettDateField.TagId).flatMap(f=>FutSettDateField.decode(f)),
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(IDSourceField.TagId).flatMap(f=>IDSourceField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(MaturityMonthYearField.TagId).flatMap(f=>MaturityMonthYearField.decode(f)),
        myFields.get(MaturityDayField.TagId).flatMap(f=>MaturityDayField.decode(f)),
        myFields.get(PutOrCallField.TagId).flatMap(f=>PutOrCallField.decode(f)),
        myFields.get(StrikePriceField.TagId).flatMap(f=>StrikePriceField.decode(f)),
        myFields.get(OptAttributeField.TagId).flatMap(f=>OptAttributeField.decode(f)),
        myFields.get(ContractMultiplierField.TagId).flatMap(f=>ContractMultiplierField.decode(f)),
        myFields.get(CouponRateField.TagId).flatMap(f=>CouponRateField.decode(f)),
        myFields.get(SecurityExchangeField.TagId).flatMap(f=>SecurityExchangeField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(EncodedIssuerLenField.TagId).flatMap(f=>EncodedIssuerLenField.decode(f)),
        myFields.get(EncodedIssuerField.TagId).flatMap(f=>EncodedIssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        myFields.get(EncodedSecurityDescLenField.TagId).flatMap(f=>EncodedSecurityDescLenField.decode(f)),
        myFields.get(EncodedSecurityDescField.TagId).flatMap(f=>EncodedSecurityDescField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        myFields.get(OrderQtyField.TagId).flatMap(f=>OrderQtyField.decode(f)),
        myFields.get(CashOrderQtyField.TagId).flatMap(f=>CashOrderQtyField.decode(f)),
        myFields.get(OrdTypeField.TagId).flatMap(f=>OrdTypeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(StopPxField.TagId).flatMap(f=>StopPxField.decode(f)),
        myFields.get(PegDifferenceField.TagId).flatMap(f=>PegDifferenceField.decode(f)),
        myFields.get(DiscretionInstField.TagId).flatMap(f=>DiscretionInstField.decode(f)),
        myFields.get(DiscretionOffsetField.TagId).flatMap(f=>DiscretionOffsetField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(ComplianceIDField.TagId).flatMap(f=>ComplianceIDField.decode(f)),
        myFields.get(SolicitedFlagField.TagId).flatMap(f=>SolicitedFlagField.decode(f)),
        myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
        myFields.get(EffectiveTimeField.TagId).flatMap(f=>EffectiveTimeField.decode(f)),
        myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
        myFields.get(Rule80AField.TagId).flatMap(f=>Rule80AField.decode(f)),
        myFields.get(LastSharesField.TagId).flatMap(f=>LastSharesField.decode(f)),
        myFields.get(LastPxField.TagId).flatMap(f=>LastPxField.decode(f)),
        myFields.get(LastSpotRateField.TagId).flatMap(f=>LastSpotRateField.decode(f)),
        myFields.get(LastForwardPointsField.TagId).flatMap(f=>LastForwardPointsField.decode(f)),
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(LastCapacityField.TagId).flatMap(f=>LastCapacityField.decode(f)),
        LeavesQtyField.decode(myFields.get(LeavesQtyField.TagId)).get,
        CumQtyField.decode(myFields.get(CumQtyField.TagId)).get,
        AvgPxField.decode(myFields.get(AvgPxField.TagId)).get,
        myFields.get(DayOrderQtyField.TagId).flatMap(f=>DayOrderQtyField.decode(f)),
        myFields.get(DayCumQtyField.TagId).flatMap(f=>DayCumQtyField.decode(f)),
        myFields.get(DayAvgPxField.TagId).flatMap(f=>DayAvgPxField.decode(f)),
        myFields.get(GTBookingInstField.TagId).flatMap(f=>GTBookingInstField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(ReportToExchField.TagId).flatMap(f=>ReportToExchField.decode(f)),
        myFields.get(CommissionField.TagId).flatMap(f=>CommissionField.decode(f)),
        myFields.get(CommTypeField.TagId).flatMap(f=>CommTypeField.decode(f)),
        myFields.get(GrossTradeAmtField.TagId).flatMap(f=>GrossTradeAmtField.decode(f)),
        myFields.get(SettlCurrAmtField.TagId).flatMap(f=>SettlCurrAmtField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(SettlCurrFxRateField.TagId).flatMap(f=>SettlCurrFxRateField.decode(f)),
        myFields.get(SettlCurrFxRateCalcField.TagId).flatMap(f=>SettlCurrFxRateCalcField.decode(f)),
        myFields.get(HandlInstField.TagId).flatMap(f=>HandlInstField.decode(f)),
        myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
        myFields.get(MaxFloorField.TagId).flatMap(f=>MaxFloorField.decode(f)),
        myFields.get(OpenCloseField.TagId).flatMap(f=>OpenCloseField.decode(f)),
        myFields.get(MaxShowField.TagId).flatMap(f=>MaxShowField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(FutSettDate2Field.TagId).flatMap(f=>FutSettDate2Field.decode(f)),
        myFields.get(OrderQty2Field.TagId).flatMap(f=>OrderQty2Field.decode(f)),
        myFields.get(ClearingFirmField.TagId).flatMap(f=>ClearingFirmField.decode(f)),
        myFields.get(ClearingAccountField.TagId).flatMap(f=>ClearingAccountField.decode(f)),
        myFields.get(MultiLegReportingTypeField.TagId).flatMap(f=>MultiLegReportingTypeField.decode(f))))
    } else None
  }

    
}
     