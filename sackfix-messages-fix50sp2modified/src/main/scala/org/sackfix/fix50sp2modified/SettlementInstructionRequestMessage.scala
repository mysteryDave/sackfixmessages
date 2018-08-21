package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class SettlementInstructionRequestMessage(settlInstReqIDField:SettlInstReqIDField,
                                               transactTimeField:TransactTimeField,
                                               partiesComponent:Option[PartiesComponent]=None,
                                               allocAccountField:Option[AllocAccountField]=None,
                                               allocAcctIDSourceField:Option[AllocAcctIDSourceField]=None,
                                               sideField:Option[SideField]=None,
                                               productField:Option[ProductField]=None,
                                               securityTypeField:Option[SecurityTypeField]=None,
                                               cFICodeField:Option[CFICodeField]=None,
                                               settlCurrencyField:Option[SettlCurrencyField]=None,
                                               effectiveTimeField:Option[EffectiveTimeField]=None,
                                               expireTimeField:Option[ExpireTimeField]=None,
                                               lastUpdateTimeField:Option[LastUpdateTimeField]=None,
                                               standInstDbTypeField:Option[StandInstDbTypeField]=None,
                                               standInstDbNameField:Option[StandInstDbNameField]=None,
                                               standInstDbIDField:Option[StandInstDbIDField]=None) extends SfFixMessageBody("AV")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,settlInstReqIDField)
    fmt(b,transactTimeField)
    partiesComponent.foreach(fmt(b,_))
    allocAccountField.foreach(fmt(b,_))
    allocAcctIDSourceField.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    productField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    cFICodeField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    effectiveTimeField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    lastUpdateTimeField.foreach(fmt(b,_))
    standInstDbTypeField.foreach(fmt(b,_))
    standInstDbNameField.foreach(fmt(b,_))
    standInstDbIDField.foreach(fmt(b,_))
    b
  }

}
     
object SettlementInstructionRequestMessage extends SfFixMessageDecoder {
  val MsgType="AV"
  val MsgName="SettlementInstructionRequest"
             
  override val MandatoryFields = HashSet[Int](
    SettlInstReqIDField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    AllocAccountField.TagId, AllocAcctIDSourceField.TagId, SideField.TagId, ProductField.TagId, SecurityTypeField.TagId, 
    CFICodeField.TagId, SettlCurrencyField.TagId, EffectiveTimeField.TagId, ExpireTimeField.TagId, LastUpdateTimeField.TagId, 
    StandInstDbTypeField.TagId, StandInstDbNameField.TagId, StandInstDbIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SettlInstReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SettlementInstructionRequestMessage(SettlInstReqIDField.decode(myFields.get(SettlInstReqIDField.TagId)).get,
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        PartiesComponent.decode(flds, startPos),
        myFields.get(AllocAccountField.TagId).flatMap(f=>AllocAccountField.decode(f)),
        myFields.get(AllocAcctIDSourceField.TagId).flatMap(f=>AllocAcctIDSourceField.decode(f)),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        myFields.get(ProductField.TagId).flatMap(f=>ProductField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(CFICodeField.TagId).flatMap(f=>CFICodeField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        myFields.get(EffectiveTimeField.TagId).flatMap(f=>EffectiveTimeField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(LastUpdateTimeField.TagId).flatMap(f=>LastUpdateTimeField.decode(f)),
        myFields.get(StandInstDbTypeField.TagId).flatMap(f=>StandInstDbTypeField.decode(f)),
        myFields.get(StandInstDbNameField.TagId).flatMap(f=>StandInstDbNameField.decode(f)),
        myFields.get(StandInstDbIDField.TagId).flatMap(f=>StandInstDbIDField.decode(f))))
    } else None
  }

    
}
     