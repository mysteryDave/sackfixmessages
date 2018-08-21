package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class CrossOrderCancelReplaceRequestMessage(orderIDField:Option[OrderIDField]=None,
                                                 crossIDField:CrossIDField,
                                                 origCrossIDField:OrigCrossIDField,
                                                 hostCrossIDField:Option[HostCrossIDField]=None,
                                                 crossTypeField:CrossTypeField,
                                                 crossPrioritizationField:CrossPrioritizationField,
                                                 rootPartiesComponent:Option[RootPartiesComponent]=None,
                                                 sideCrossOrdModGrpComponent:SideCrossOrdModGrpComponent,
                                                 instrumentComponent:InstrumentComponent,
                                                 undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                                 instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                                 settlTypeField:Option[SettlTypeField]=None,
                                                 settlDateField:Option[SettlDateField]=None,
                                                 handlInstField:Option[HandlInstField]=None,
                                                 execInstField:Option[ExecInstField]=None,
                                                 minQtyField:Option[MinQtyField]=None,
                                                 matchIncrementField:Option[MatchIncrementField]=None,
                                                 maxPriceLevelsField:Option[MaxPriceLevelsField]=None,
                                                 displayInstructionComponent:Option[DisplayInstructionComponent]=None,
                                                 maxFloorField:Option[MaxFloorField]=None,
                                                 exDestinationField:Option[ExDestinationField]=None,
                                                 exDestinationIDSourceField:Option[ExDestinationIDSourceField]=None,
                                                 trdgSesGrpComponent:Option[TrdgSesGrpComponent]=None,
                                                 processCodeField:Option[ProcessCodeField]=None,
                                                 prevClosePxField:Option[PrevClosePxField]=None,
                                                 locateReqdField:Option[LocateReqdField]=None,
                                                 transactTimeField:TransactTimeField,
                                                 transBkdTimeField:Option[TransBkdTimeField]=None,
                                                 stipulationsComponent:Option[StipulationsComponent]=None,
                                                 ordTypeField:OrdTypeField,
                                                 priceTypeField:Option[PriceTypeField]=None,
                                                 priceField:Option[PriceField]=None,
                                                 priceProtectionScopeField:Option[PriceProtectionScopeField]=None,
                                                 stopPxField:Option[StopPxField]=None,
                                                 triggeringInstructionComponent:Option[TriggeringInstructionComponent]=None,
                                                 spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                                 yieldDataComponent:Option[YieldDataComponent]=None,
                                                 currencyField:Option[CurrencyField]=None,
                                                 complianceIDField:Option[ComplianceIDField]=None,
                                                 iOIIDField:Option[IOIIDField]=None,
                                                 quoteIDField:Option[QuoteIDField]=None,
                                                 timeInForceField:Option[TimeInForceField]=None,
                                                 effectiveTimeField:Option[EffectiveTimeField]=None,
                                                 expireDateField:Option[ExpireDateField]=None,
                                                 expireTimeField:Option[ExpireTimeField]=None,
                                                 gTBookingInstField:Option[GTBookingInstField]=None,
                                                 maxShowField:Option[MaxShowField]=None,
                                                 pegInstructionsComponent:Option[PegInstructionsComponent]=None,
                                                 discretionInstructionsComponent:Option[DiscretionInstructionsComponent]=None,
                                                 targetStrategyField:Option[TargetStrategyField]=None,
                                                 strategyParametersGrpComponent:Option[StrategyParametersGrpComponent]=None,
                                                 targetStrategyParametersField:Option[TargetStrategyParametersField]=None,
                                                 participationRateField:Option[ParticipationRateField]=None,
                                                 cancellationRightsField:Option[CancellationRightsField]=None,
                                                 moneyLaunderingStatusField:Option[MoneyLaunderingStatusField]=None,
                                                 registIDField:Option[RegistIDField]=None,
                                                 designationField:Option[DesignationField]=None) extends SfFixMessageBody("t")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    fmt(b,crossIDField)
    fmt(b,origCrossIDField)
    hostCrossIDField.foreach(fmt(b,_))
    fmt(b,crossTypeField)
    fmt(b,crossPrioritizationField)
    rootPartiesComponent.foreach(fmt(b,_))
    fmt(b,sideCrossOrdModGrpComponent)
    fmt(b,instrumentComponent)
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    handlInstField.foreach(fmt(b,_))
    execInstField.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    matchIncrementField.foreach(fmt(b,_))
    maxPriceLevelsField.foreach(fmt(b,_))
    displayInstructionComponent.foreach(fmt(b,_))
    maxFloorField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    exDestinationIDSourceField.foreach(fmt(b,_))
    trdgSesGrpComponent.foreach(fmt(b,_))
    processCodeField.foreach(fmt(b,_))
    prevClosePxField.foreach(fmt(b,_))
    locateReqdField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    transBkdTimeField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    fmt(b,ordTypeField)
    priceTypeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    priceProtectionScopeField.foreach(fmt(b,_))
    stopPxField.foreach(fmt(b,_))
    triggeringInstructionComponent.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    complianceIDField.foreach(fmt(b,_))
    iOIIDField.foreach(fmt(b,_))
    quoteIDField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    effectiveTimeField.foreach(fmt(b,_))
    expireDateField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    gTBookingInstField.foreach(fmt(b,_))
    maxShowField.foreach(fmt(b,_))
    pegInstructionsComponent.foreach(fmt(b,_))
    discretionInstructionsComponent.foreach(fmt(b,_))
    targetStrategyField.foreach(fmt(b,_))
    strategyParametersGrpComponent.foreach(fmt(b,_))
    targetStrategyParametersField.foreach(fmt(b,_))
    participationRateField.foreach(fmt(b,_))
    cancellationRightsField.foreach(fmt(b,_))
    moneyLaunderingStatusField.foreach(fmt(b,_))
    registIDField.foreach(fmt(b,_))
    designationField.foreach(fmt(b,_))
    b
  }

}
     
object CrossOrderCancelReplaceRequestMessage extends SfFixMessageDecoder {
  val MsgType="t"
  val MsgName="CrossOrderCancelReplaceRequest"
             
  override val MandatoryFields = HashSet[Int](
    CrossIDField.TagId, OrigCrossIDField.TagId, CrossTypeField.TagId, CrossPrioritizationField.TagId, TransactTimeField.TagId, 
    OrdTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RootPartiesComponent.isMandatoryField(tagId) || SideCrossOrdModGrpComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || 
    InstrmtLegGrpComponent.isMandatoryField(tagId) || DisplayInstructionComponent.isMandatoryField(tagId) || TrdgSesGrpComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || 
    TriggeringInstructionComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || PegInstructionsComponent.isMandatoryField(tagId) || 
    DiscretionInstructionsComponent.isMandatoryField(tagId) || StrategyParametersGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, HostCrossIDField.TagId, SettlTypeField.TagId, SettlDateField.TagId, HandlInstField.TagId, 
    ExecInstField.TagId, MinQtyField.TagId, MatchIncrementField.TagId, MaxPriceLevelsField.TagId, MaxFloorField.TagId, 
    ExDestinationField.TagId, ExDestinationIDSourceField.TagId, ProcessCodeField.TagId, PrevClosePxField.TagId, LocateReqdField.TagId, 
    TransBkdTimeField.TagId, PriceTypeField.TagId, PriceField.TagId, PriceProtectionScopeField.TagId, StopPxField.TagId, 
    CurrencyField.TagId, ComplianceIDField.TagId, IOIIDField.TagId, QuoteIDField.TagId, TimeInForceField.TagId, 
    EffectiveTimeField.TagId, ExpireDateField.TagId, ExpireTimeField.TagId, GTBookingInstField.TagId, MaxShowField.TagId, 
    TargetStrategyField.TagId, TargetStrategyParametersField.TagId, ParticipationRateField.TagId, CancellationRightsField.TagId, MoneyLaunderingStatusField.TagId, 
    RegistIDField.TagId, DesignationField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RootPartiesComponent.isOptionalField(tagId) || SideCrossOrdModGrpComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || 
    InstrmtLegGrpComponent.isOptionalField(tagId) || DisplayInstructionComponent.isOptionalField(tagId) || TrdgSesGrpComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || 
    TriggeringInstructionComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || PegInstructionsComponent.isOptionalField(tagId) || 
    DiscretionInstructionsComponent.isOptionalField(tagId) || StrategyParametersGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RootPartiesComponent.isFieldOf(tagId) || SideCrossOrdModGrpComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || DisplayInstructionComponent.isFieldOf(tagId) || 
    TrdgSesGrpComponent.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId) || TriggeringInstructionComponent.isFieldOf(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId) || PegInstructionsComponent.isFieldOf(tagId) || 
    DiscretionInstructionsComponent.isFieldOf(tagId) || StrategyParametersGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(CrossOrderCancelReplaceRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        CrossIDField.decode(myFields.get(CrossIDField.TagId)).get,
        OrigCrossIDField.decode(myFields.get(OrigCrossIDField.TagId)).get,
        myFields.get(HostCrossIDField.TagId).flatMap(f=>HostCrossIDField.decode(f)),
        CrossTypeField.decode(myFields.get(CrossTypeField.TagId)).get,
        CrossPrioritizationField.decode(myFields.get(CrossPrioritizationField.TagId)).get,
        RootPartiesComponent.decode(flds, startPos),
        SideCrossOrdModGrpComponent.decode(flds, startPos).get,
        InstrumentComponent.decode(flds, startPos).get,
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(HandlInstField.TagId).flatMap(f=>HandlInstField.decode(f)),
        myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
        myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
        myFields.get(MatchIncrementField.TagId).flatMap(f=>MatchIncrementField.decode(f)),
        myFields.get(MaxPriceLevelsField.TagId).flatMap(f=>MaxPriceLevelsField.decode(f)),
        DisplayInstructionComponent.decode(flds, startPos),
        myFields.get(MaxFloorField.TagId).flatMap(f=>MaxFloorField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        myFields.get(ExDestinationIDSourceField.TagId).flatMap(f=>ExDestinationIDSourceField.decode(f)),
        TrdgSesGrpComponent.decode(flds, startPos),
        myFields.get(ProcessCodeField.TagId).flatMap(f=>ProcessCodeField.decode(f)),
        myFields.get(PrevClosePxField.TagId).flatMap(f=>PrevClosePxField.decode(f)),
        myFields.get(LocateReqdField.TagId).flatMap(f=>LocateReqdField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(TransBkdTimeField.TagId).flatMap(f=>TransBkdTimeField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        OrdTypeField.decode(myFields.get(OrdTypeField.TagId)).get,
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(PriceProtectionScopeField.TagId).flatMap(f=>PriceProtectionScopeField.decode(f)),
        myFields.get(StopPxField.TagId).flatMap(f=>StopPxField.decode(f)),
        TriggeringInstructionComponent.decode(flds, startPos),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(ComplianceIDField.TagId).flatMap(f=>ComplianceIDField.decode(f)),
        myFields.get(IOIIDField.TagId).flatMap(f=>IOIIDField.decode(f)),
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
        myFields.get(EffectiveTimeField.TagId).flatMap(f=>EffectiveTimeField.decode(f)),
        myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(GTBookingInstField.TagId).flatMap(f=>GTBookingInstField.decode(f)),
        myFields.get(MaxShowField.TagId).flatMap(f=>MaxShowField.decode(f)),
        PegInstructionsComponent.decode(flds, startPos),
        DiscretionInstructionsComponent.decode(flds, startPos),
        myFields.get(TargetStrategyField.TagId).flatMap(f=>TargetStrategyField.decode(f)),
        StrategyParametersGrpComponent.decode(flds, startPos),
        myFields.get(TargetStrategyParametersField.TagId).flatMap(f=>TargetStrategyParametersField.decode(f)),
        myFields.get(ParticipationRateField.TagId).flatMap(f=>ParticipationRateField.decode(f)),
        myFields.get(CancellationRightsField.TagId).flatMap(f=>CancellationRightsField.decode(f)),
        myFields.get(MoneyLaunderingStatusField.TagId).flatMap(f=>MoneyLaunderingStatusField.decode(f)),
        myFields.get(RegistIDField.TagId).flatMap(f=>RegistIDField.decode(f)),
        myFields.get(DesignationField.TagId).flatMap(f=>DesignationField.decode(f))))
    } else None
  }

    
}
     